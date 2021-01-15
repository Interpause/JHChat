

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 181801038883042938L;
	private JPanel contentPane;
	JTextField textField;
	public JTextArea textArea;
	public String motd = "Welcome to this server!";
	private JTextField textField_1;
	private JScrollPane scrollPane_1;
	private JTextField txtServerSend;
	private JButton btnSend;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public frame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	ProfileScanner.save();
		    	System.exit(0);
		    }
		});
		setBounds(100, 100, 750, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPoweredByJhtech = new JLabel("Powered by JHTech");
		lblPoweredByJhtech.setBounds(10, 11, 133, 14);
		contentPane.add(lblPoweredByJhtech);
		
		textField = new JTextField();
		textField.setBounds(85, 145, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnKick = new JButton("Kick");
		btnKick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfileScanner.getProfile(textField.getText()).shutDown();
				Sender.log(textField.getText()+" was kicked.");
				textField.setText("");
			}
		});
		btnKick.setBounds(191, 144, 89, 23);
		contentPane.add(btnKick);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 11, 431, 624);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 242, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSetMotd = new JButton("set MOTD");
		btnSetMotd.setBounds(191, 241, 89, 23);
		btnSetMotd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				motd = textField_1.getText();
			}
		});
		contentPane.add(btnSetMotd);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 298, 270, 245);
		contentPane.add(scrollPane_1);
		
		txtServerSend = new JTextField();
		scrollPane_1.setViewportView(txtServerSend);
		txtServerSend.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(10, 554, 89, 23);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sender.send(txtServerSend.getText(),ProfileScanner.getProfile("SYSTEM"));
				txtServerSend.setText("");
			}
		});
		contentPane.add(btnSend);
	}
}
