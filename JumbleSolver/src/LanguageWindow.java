import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class LanguageWindow extends JFrame {

	private JPanel contentPane;
	File[] files;
	GameWindow gw;


	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LanguageWindow frame = new LanguageWindow(gw);
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
	public LanguageWindow(GameWindow gw) {
		this.gw = gw;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
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
		btnOk.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				gw.setWrdFile(files[comboBox.getSelectedIndex()]);
				dispatchEvent(new WindowEvent((Window) SwingUtilities.getRoot((Component) e.getSource()), WindowEvent.WINDOW_CLOSING));
			}
		});
		ArrayList<String> Languages = getLangs();
		for(String temp : Languages){
			comboBox.addItem(temp);
		}
		boolean exists = false;
		for (int index = 0; index < comboBox.getItemCount() && !exists; index++) {
			if (comboBox.getItemAt(index).equals("English")) {
				exists = true;
				comboBox.setSelectedIndex(index);
			}
		}
	}

	private ArrayList<String> getLangs(){
		ArrayList<String> toRe = new ArrayList<String>();
		File folder = new File("./info");
		files = folder.listFiles();
		if (files.length == 0){
			JOptionPane.showMessageDialog(new JFrame(),"There were no files in the folder info in the same directory as this program. Please add language files in this format: EnglishDict or EspanoleDicts","No Language File Detected",JOptionPane.ERROR_MESSAGE);
		}
		else{
			for(int i = 0; i < files.length; i++){
				String temp = files[i].getName();
				if(temp.contains("Dict")){
					toRe.add(temp.substring(0, temp.indexOf("Dict")));
				}

			}
		}
		return toRe;
	}

}
