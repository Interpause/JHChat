
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 331443330421539495L;
	private JPanel contentPane;
	public static JButton send = new JButton("send");
	public static JTextArea sender = new JTextArea();
	public static JTextArea viewer = new JTextArea();
	public static int entcount = 0;
	public static boolean accept;
	final static JButton btnSetIp = new JButton("set ip");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFrame frame = new GuiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		viewer.append("Welcome to JH Global Chat Cilent V5.\nInput in ip.\n");
	}

	/**
	 * Create the frame.
	 */
	public GuiFrame() {
		addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
            	SocketSender.setSendValue(2);
            	if(SocketCreator.isActive()){
            	SocketSender.send("SHUTDOWN");
            	System.exit(0);
            	}
            	System.exit(0);
            }
            });
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setResizable(false);
		setTitle("JH Global Chat Client V5");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1244, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Game Screen GUI");
		
		JLabel lblPoweredByJhtech = new JLabel("Powered by JHTech");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(send)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSetIp)
							.addPreferredGap(ComponentPlacement.RELATED, 1042, Short.MAX_VALUE)
							.addComponent(lblPoweredByJhtech)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(send)
						.addComponent(btnSetIp)
						.addComponent(lblPoweredByJhtech)))
		);
		send.setEnabled(false);
		
		send.addActionListener(new Actor());
		btnSetIp.addActionListener(new Actor());
		
		sender.setWrapStyleWord(true);
		sender.setLineWrap(true);
		scrollPane_1.setViewportView(sender);
		sender.setFont(new Font("Arial", Font.PLAIN, 13));
		
		viewer.setLineWrap(true);
		viewer.setWrapStyleWord(true);
		viewer.setFont(new Font("Arial", Font.PLAIN, 13));
		viewer.setEditable(false);
		scrollPane.setViewportView(viewer);
		contentPane.setLayout(gl_contentPane);
	}
}
