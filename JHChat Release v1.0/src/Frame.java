
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.ScrollPaneConstants;


import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;


public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8451069343737468190L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextArea view;
	private boolean ButtonFunc = false;
	private JTextArea write;
	private JButton button;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	JPanel panel;
	/**
	 * Create the frame.
	 */
	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("JHChat Release v1");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 444, 403);
		contentPane.add(scrollPane);
		
		
		view = new JTextArea();
		view.setText("Welcome to JHChat Release V1!");
		view.setWrapStyleWord(true);
		view.setLineWrap(true);
		view.setFont(new Font("Arial", Font.PLAIN, 12));
		view.setEditable(false);
		scrollPane.setViewportView(view);
		
		write = new JTextArea();
		write.setWrapStyleWord(true);
		write.setLineWrap(true);
		write.setFont(new Font("Arial", Font.PLAIN, 12));
		write.setBounds(0, 414, 444, 97);
		write.addKeyListener(new KeyReader());
		contentPane.add(write);
		
		button = new JButton("Set Ip");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable(){

					@Override
					public void run() {
						if(ButtonFunc == false){
							button.setText("Set Ip");
							ButtonFunc = SocketCreator.createSocket(getText());
						}else{
							button.setText("send");
							Communicator.write(getText(), 1);
						}
					}
					
				}).start();
				
			}
		});
		button.setBounds(10, 522, 70, 22);
		contentPane.add(button);
		
		JLabel lblPoweredByJhtech = new JLabel("Powered by JHTech");
		lblPoweredByJhtech.setFont(new Font("Arial", Font.BOLD, 14));
		lblPoweredByJhtech.setBounds(616, 525, 138, 14);
		contentPane.add(lblPoweredByJhtech);
		
		panel = new JPanel();
		panel.setToolTipText("Tic Tac Toe Game Pane");
		panel.setBounds(454, 0, 300, 305);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setEnabled(false);
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn1.setFont(new Font("Arial", Font.BOLD, 70));
		btn1.setBounds(0, 0, 100, 100);
		panel.add(btn1);
		
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn2.setFont(new Font("Arial", Font.BOLD, 70));
		btn2.setBounds(100, 0, 100, 100);
		panel.add(btn2);
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn3.setFont(new Font("Arial", Font.BOLD, 70));
		btn3.setBounds(200, 0, 100, 100);
		panel.add(btn3);
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn4.setFont(new Font("Arial", Font.BOLD, 70));
		btn4.setBounds(0, 100, 100, 100);
		panel.add(btn4);
		
		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn5.setFont(new Font("Arial", Font.BOLD, 70));
		btn5.setBounds(100, 100, 100, 100);
		panel.add(btn5);
		
		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn6.setFont(new Font("Arial", Font.BOLD, 70));
		btn6.setBounds(200, 100, 100, 100);
		panel.add(btn6);
		
		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn7.setFont(new Font("Arial", Font.BOLD, 70));
		btn7.setBounds(0, 200, 100, 100);
		panel.add(btn7);
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn8.setFont(new Font("Arial", Font.BOLD, 70));
		btn8.setBounds(100, 200, 100, 100);
		panel.add(btn8);
		
		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionevent) {
			}
		});
		btn9.setFont(new Font("Arial", Font.BOLD, 70));
		btn9.setBounds(200, 200, 100, 100);
		panel.add(btn9);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
	}
	public void write(String write){
		view.append("\n"+write);
		view.setCaretPosition(view.getDocument().getLength());
	}
	
	
	public void setTTTButton(int btn, char letter){
		switch(btn){
		case 1:btn1.setText(String.valueOf(letter)); break;
		case 2:btn2.setText(String.valueOf(letter)); break;
		case 3:btn3.setText(String.valueOf(letter)); break;
		case 4:btn4.setText(String.valueOf(letter)); break;
		case 5:btn5.setText(String.valueOf(letter)); break;
		case 6:btn6.setText(String.valueOf(letter)); break;
		case 7:btn7.setText(String.valueOf(letter)); break;
		case 8:btn8.setText(String.valueOf(letter)); break;
		case 9:btn9.setText(String.valueOf(letter)); break;
		}
	}
	
	public void setTTTMode(boolean active){
		btn1.setEnabled(active);
		btn2.setEnabled(active);
		btn3.setEnabled(active);
		btn4.setEnabled(active);
		btn5.setEnabled(active);
		btn6.setEnabled(active);
		btn7.setEnabled(active);
		btn8.setEnabled(active);
		btn9.setEnabled(active);
	}
	
	public void TTTClear(){
		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn5.setText("");
		btn6.setText("");
		btn7.setText("");
		btn8.setText("");
		btn9.setText("");
	}
	
	public void setButtonEnabled(boolean a){
		button.setEnabled(a);
	}
	
	public String getText(){
		try{
			return write.getText();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			write.setText("");
		}
		return "";
	}
	
	public void setButtonFunc(boolean a){
		ButtonFunc = a;
		if(a==true){
			button.setText("send");
		}else{
			button.setText("Set Ip");
		}
	}
	class KeyReader implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER&&e.getSource()==write){
    	if(ButtonFunc == false){
			button.setText("Set Ip");
			ButtonFunc = SocketCreator.createSocket(getText().trim());
		}else{
			button.setText("send");
			Communicator.write(getText().trim(), 1);
		}
    }
}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}


