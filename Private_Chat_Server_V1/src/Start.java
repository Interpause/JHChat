
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class Start extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String MOTD;
	private JPanel contentPane;
	private JTextField textField;
	static boolean b1 = true;
	static JTextArea textArea;
	static JLabel lblServerRunningClose;
	static JScrollPane scrollPane;
	
	public Start() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
            	File a = new File("chat.txt");
            	if(!a.exists()){
        			try {
        				a.createNewFile();
        			} catch (IOException e) {
        			}
        			BufferedWriter output = null;
        			try {
        				output = new BufferedWriter(new java.io.FileWriter(a));
        			} catch (IOException e) {
        			}
        			try {		
        				output.write(textArea.getText());
        				output.close();
        			} catch (IOException e) {
        			}
            	}
                System.exit(0);
            }
        });
		final JLabel lblNewLabel = new JLabel("Input in MOTD:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		final JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnDone){
				MOTD = textField.getText();
				b1 = false;
				lblNewLabel.setVisible(false);
				textField.setVisible(false);
				btnDone.setVisible(false);
				lblServerRunningClose.setVisible(true);
				textArea.setVisible(true);
				scrollPane.setVisible(true);
				}
			}
		});
		
		lblServerRunningClose = new JLabel("Server Running... Close Screen To Shut Down.");
		lblServerRunningClose.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(btnDone, Alignment.LEADING)
						.addComponent(lblServerRunningClose, Alignment.LEADING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDone)
					.addGap(18)
					.addComponent(lblServerRunningClose)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		textArea.setVisible(false);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	static String CallMotd(){
		return MOTD;
				}
	static boolean isDone(){
		return b1;
	}
	static void Connection(String cilentid){
		textArea.append(cilentid + "\n");
}
	static void Chat(String chat){
		textArea.append(chat + "\n");
	}
}