import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GameWindow extends JFrame {


	private static final long serialVersionUID = 5183479711955824410L;
	private JPanel pnlMain;
	private JTextField inWordNum;
	private JTextField inSpaceNum;
	JPanel pnlBody, pnlFinal, pnlSolve, pnlSpaceCnt, pnlWordCnt;
	JScrollPane scPnlBody;
	JLabel lblWNum, lblSpaceCount;
	JButton btnSolve;
	ArrayList<JPanel> pnls = new ArrayList<JPanel>();
	ArrayList<CBtnPanel> minPnls = new ArrayList<CBtnPanel>();
	ArrayList<JTextField> txts = new ArrayList<JTextField>();
	ArrayList<ArrayList<JLabel>> lbls = new ArrayList<ArrayList<JLabel>>();
	ArrayList<CircleBtn> cBtns = new ArrayList<CircleBtn>();
	ArrayList<SpcBtn> sBtns = new ArrayList<SpcBtn>();
	int circles = 0, spaces = 0;
	LanguageWindow lWin = new LanguageWindow(this);
	File chosenFile;
	HashMap<String,HashSet<String>> langmap;
	FileRead fileRead = new FileRead();
	
	//Getters and setters here
	public ArrayList<String> getJumWords(){
		//Returns array list of all jumbled words inputed, may have empty strings at end
		ArrayList<String> toRe = new ArrayList<String>();
		for(JTextField temp : txts){
			toRe.add(temp.getText());
		}
		return toRe;
	}
	
	public File getWrdFile(){
		//Returns users chosen language file
		return chosenFile;
	}
	
	public ArrayList<ArrayList<Integer>> getCircled(){
		return null;
	}
	
	public HashMap<String,HashSet<String>> getHashMap(){
		return langmap;
	}
	
	public void setWrdFile(File set){
		chosenFile = set;
		System.out.println(chosenFile);
		fileRead.read(chosenFile);
		langmap = fileRead.getMap();
	}
	
	public void openLW(){
		lWin.open();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//NICOLE WAS HERE (ignore testing git)

				try {
					GameWindow frame = new GameWindow();
					frame.openLW();
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
		scPnlBody = new JScrollPane();
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
	
	private void makeFinalBtns(){
		pnlFinal.removeAll();
		sBtns.clear();
		for(int i = 0; i < circles; i++){
			sBtns.add(new SpcBtn());
			pnlFinal.add(sBtns.get(i), "cell " + i + " 0");
			sBtns.get(i).addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					if(((CircleBtn) e.getSource()).getCircle()){
						spaces++;
						((CircleBtn) e.getSource()).setCircle(false);
					}
					else{
						spaces--;
						((CircleBtn) e.getSource()).setCircle(true);
					}
				}
			});
		}
		pnlFinal.revalidate();
		pnlFinal.repaint();
	}
	
	private void makeCirButtons(String in, int index){
		System.out.println("called");
		minPnls.get(index).clrBtns();
		minPnls.get(index).removeAll();
		if(in.length() > 0 && !in.contains(" ")){
			for(int i = 0; i < in.length(); i++){
				
				minPnls.get(index).addBtn(new CircleBtn());
				minPnls.get(index).getCBtn(i).addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						if(((CircleBtn) e.getSource()).getCircle()){
							circles++;
							makeFinalBtns();
							((CircleBtn) e.getSource()).setCircle(false);
						}
						else{
							circles--;
							makeFinalBtns();
							((CircleBtn) e.getSource()).setCircle(true);
						}
					}
				});
				minPnls.get(index).add(minPnls.get(index).getCBtn(i), "cell "+i+" 0");
				System.out.println("looped "+i);
			}
			
		}
		else{
			
		}
		pnlBody.revalidate();
		pnlBody.repaint();
	}
	
	private void genWordIns(String num){
		System.out.println("changed");
		try{
			System.out.println("mark 1");
			minPnls.clear();
			pnls.clear();
			txts.clear();
			pnlBody.removeAll();
			for(int i = 0; i < Integer.parseInt(num); i++){
				pnls.add(new JPanel());
				pnls.get(i).setLayout(new MigLayout("","10[]20[grow]","[]"));
				txts.add(new JTextField());
				minPnls.add(new CBtnPanel());
				minPnls.get(i).setLayout(new MigLayout("","[]","[]"));
				pnls.get(i).add(minPnls.get(i), "cell 1 0,growx");
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
						JTextField owner = (JTextField) e.getDocument().getProperty("owner");
						int index = (int) e.getDocument().getProperty("index");
						makeCirButtons(owner.getText(), index);
					}
					public void insertUpdate(DocumentEvent e) {
						JTextField owner = (JTextField) e.getDocument().getProperty("owner");
						int index = (int) e.getDocument().getProperty("index");
						makeCirButtons(owner.getText(), index);
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
