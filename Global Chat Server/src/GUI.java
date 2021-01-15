import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;


public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7466782193912627641L;
	private JPanel contentPane;
	static JTextField motd;
	static JTextArea viewer;
	static JButton setmotd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		Thread t1 = new Thread(new SocketEstablisher());
		t1.start();
		Thread t2 = new Thread(new PacketSender());
		t2.start();
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle("JH Global Chat Server Operation Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		motd = new JTextField();
		motd.setColumns(10);
		
		setmotd = new JButton("Set MOTD");
		setmotd.addActionListener(new Actor());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(motd, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
						.addComponent(setmotd))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(motd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(setmotd)))
					.addContainerGap())
		);
		
		viewer = new JTextArea();
		viewer.setLineWrap(true);
		viewer.setWrapStyleWord(true);
		viewer.setEditable(false);
		scrollPane.setViewportView(viewer);
		contentPane.setLayout(gl_contentPane);
	}
}
