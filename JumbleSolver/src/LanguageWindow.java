import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class LanguageWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LanguageWindow frame = new LanguageWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LanguageWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "15%[grow]15%", "push[][][]push"));
		
		JLabel lblPleaseSelectA = new JLabel("Please select a language");
		contentPane.add(lblPleaseSelectA, "cell 0 0,alignx center,aligny center");
		
		JComboBox<String> comboBox = new JComboBox<String>();
		contentPane.add(comboBox, "cell 0 1,aligny center,alignx center, growx");
		
		JButton btnOk = new JButton("Ok");
		contentPane.add(btnOk, "cell 0 2,alignx center,aligny center");
		ArrayList<String> Languages = getLangs();
		for(String temp : Languages){
			comboBox.addItem(temp);
		}
	}
	
	private ArrayList<String> getLangs(){
		ArrayList<String> toRe = new ArrayList<String>();
		File folder = new File(".\\info");
		File[] files = folder.listFiles();
		for(int i = 0; i < files.length; i++){
			String temp = files[i].getName();
			if(temp.contains("Dict")){
				toRe.add(temp.substring(0, temp.indexOf("Dict")));
			}
			
		}
		return toRe;
	}

}
