import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class GameWindow extends JFrame {

	private JPanel pnlMain;
	private JTextField inWordNum;
	private JTextField inSpaceNum;
	JPanel pnlBody, pnlFinal, pnlSolve, pnlSpaceCnt, pnlWordCnt;
	JLabel lblWNum, lblSpaceCount;
	JButton btnSolve;
	ArrayList<JPanel> pnls = new ArrayList<JPanel>();
	ArrayList<JTextField> txts = new ArrayList<JTextField>();
	ArrayList<ArrayList<JLabel>> lbls = new ArrayList<ArrayList<JLabel>>();
	int Circles = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//NICOLE WAS HERE (ignore testing git)

				try {
					GameWindow frame = new GameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlMain);
		pnlMain.setLayout(new MigLayout("", "[grow]", "[][grow][][][]"));

		pnlWordCnt = new JPanel();
		pnlMain.add(pnlWordCnt, "cell 0 0,alignx center,growy");
		pnlWordCnt.setLayout(new MigLayout("", "[][30]", "[]"));

		lblWNum = new JLabel("Word Number:");
		pnlWordCnt.add(lblWNum, "cell 0 0,alignx trailing");

		inWordNum = new JTextField();
		pnlWordCnt.add(inWordNum, "cell 1 0");
		inWordNum.setColumns(3);
		inWordNum.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				genWordIns(inWordNum.getText());
			}
			public void removeUpdate(DocumentEvent e) {
				genWordIns(inWordNum.getText());
			}
			public void insertUpdate(DocumentEvent e) {
				genWordIns(inWordNum.getText());
			}
		});

		pnlBody = new JPanel();
		pnlMain.add(pnlBody, "cell 0 1,grow");
		pnlBody.setLayout(new MigLayout("", "[]", "[]"));

		pnlFinal = new JPanel();
		pnlMain.add(pnlFinal, "cell 0 3,alignx center,aligny center");
		pnlFinal.setLayout(new MigLayout("", "[]", "[]"));

		pnlSpaceCnt = new JPanel();
		pnlMain.add(pnlSpaceCnt, "cell 0 2,alignx center,aligny center");
		pnlSpaceCnt.setLayout(new MigLayout("", "[][grow]", "[]"));

		lblSpaceCount = new JLabel("Space Count:");
		pnlSpaceCnt.add(lblSpaceCount, "cell 0 0,alignx trailing");

		inSpaceNum = new JTextField();
		pnlSpaceCnt.add(inSpaceNum, "cell 1 0,growx");
		inSpaceNum.setColumns(3);

		pnlSolve = new JPanel();
		pnlMain.add(pnlSolve, "cell 0 4,alignx center,growy");
		pnlSolve.setLayout(new MigLayout("", "[]", "[]"));

		btnSolve = new JButton("Solve");
		pnlSolve.add(btnSolve, "cell 0 0");
	}
	
	private void makeCirButtons(String in, int index){
		if(in.length() > 0 && !in.contains(" ")){
			for(int i = 0; i < in.length(); i++){
				CircleLabel frank = new CircleLabel();
				frank.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						
					}
				});
			}
		}
		else{
			
		}
	}
	
	private void genWordIns(String num){
		System.out.println("changed");
		try{
			System.out.println("mark 1");
			pnls.clear();
			txts.clear();
			pnlBody.removeAll();
			for(int i = 0; i < Integer.parseInt(num); i++){
				pnls.add(new JPanel());
				pnls.get(i).setLayout(new MigLayout("","10[]20[]","[]"));
				txts.add(new JTextField());
				txts.get(i).setColumns(10);
				txts.get(i).getDocument().putProperty("owner", txts.get(i));
				txts.get(i).getDocument().putProperty("index", i);
				txts.get(i).getDocument().addDocumentListener(new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {
						JTextField owner = (JTextField) e.getDocument().getProperty("owner");
						int index = (int) e.getDocument().getProperty("index");
						makeCirButtons(owner.getText(), index);
					}
					public void removeUpdate(DocumentEvent e) {
						genWordIns(inWordNum.getText());
					}
					public void insertUpdate(DocumentEvent e) {
						genWordIns(inWordNum.getText());
					}
				});
				pnls.get(i).add(txts.get(i), "cell 0 0");
				pnlBody.add(pnls.get(i), "cell 0 "+i+", growx");
				pnlBody.revalidate();
				pnlBody.repaint();
				System.out.println("loop " + i);
			}
		}
		catch(Exception  e){
			System.out.println("oops");
			pnlBody.removeAll();
			pnlBody.revalidate();
			pnlBody.repaint();
		}
	}

}
