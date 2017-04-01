import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class GameWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][][grow][]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[][30]", "[]"));
		
		JLabel lblWNum = new JLabel("Word Number:");
		panel.add(lblWNum, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0");
		textField.setColumns(3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "cell 0 2,grow");
		panel_2.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "cell 0 3,alignx center,growy");
		panel_4.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		JLabel lblSpaceCount = new JLabel("Space Count:");
		panel_4.add(lblSpaceCount, "cell 0 0,alignx trailing");
		
		textField_1 = new JTextField();
		panel_4.add(textField_1, "cell 1 0,growx");
		textField_1.setColumns(3);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "cell 0 4,alignx center,growy");
		panel_3.setLayout(new MigLayout("", "[]", "[]"));
		
		JButton btnSolve = new JButton("Solve");
		panel_3.add(btnSolve, "cell 0 0");
	}

}
