import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JEditorPane;

import java.awt.GridBagConstraints;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JTextPane;

import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Toolkit;

public class start extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8651620327087282022L;
	public String input,name;
	private JPanel contentPane;
	public ArrayList<String> text;
	public static Socket servercon;
	public static String serverout;
	public static boolean isthere=false;
	public static String ip=null;
	static JTextArea text_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start frame = new start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread listen = new Thread(new listener());
		listen.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
		}
		text_1.append("Searching for ip.txt...\n"); 
		File iptxt = new File("./ip.txt");
		
		if(!iptxt.exists()){
			text_1.append("File not Found, creating now...\n");
			try {
				iptxt.createNewFile();
			} catch (IOException e) {
			}
			BufferedWriter output = null;
			try {
				output = new BufferedWriter(new FileWriter(iptxt));
			} catch (IOException e) {
			}
			try {
				output.write("192.168.0.33");
				output.close();
			} catch (IOException e) {
			}
		}
		text_1.append("Reading ip from file...\n");
		try {
			Scanner sc = new Scanner(iptxt);
			ip = sc.next();
		} catch (FileNotFoundException e1) {
		}
		text_1.append("Done!\n");
		while(true){
		try {
			text_1.append("Connecting...\n");
			Thread.sleep(1000);
			servercon = new Socket(ip,50000);
				break;
		} catch (Exception e) {
			text_1.append("Connection Failed, pls try again later.\n");
			text_1.setCaretPosition(text_1.getDocument().getLength());
		}	
	}		
	}

	/**
	 * Create the frame.
	 */
	public start() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("JH Chat Client V2-2");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		final JTextPane textPane_1 = new JTextPane();
		
		JButton btnSend = new JButton("send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				input = textPane_1.getText();
				textPane_1.setText("");
				System.out.println(input);
				sender.send(input,servercon);
				}		
		});
		
		JLabel lblJhtechAllRights = new JLabel("JHTech. All rights reserved.");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnSend)
					.addPreferredGap(ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
					.addComponent(lblJhtechAllRights)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textPane_1, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSend)
						.addComponent(lblJhtechAllRights)))
		);
		
		text_1 = new JTextArea();
		text_1.setEditable(false);
		text_1.setWrapStyleWord(true);
		text_1.setText("Welcome to JH Global Chat Client V2-2.\nType /help for command help.\n");
		text_1.setLineWrap(true);
		text_1.setFont(new Font("Arial", Font.PLAIN, 13));
		scrollPane.setViewportView(text_1);
		contentPane.setLayout(gl_contentPane);

	}
}
class sender{
	static void send(String out,Socket servercon){
		try {
			PrintWriter toserver = new PrintWriter(servercon.getOutputStream(),true);
			if(out.charAt(0)=='/'){
				if(out.equals("/info")){
					start.text_1.append("The programmer is John-Henry Lim\n");
				}else if(out.equals("/help")){
					start.text_1.append("/info shows info. /guessnum starts a guessing game.\n");
				}else if(out.equals("/guessnum")){
					start.text_1.append("Did not say I implement it this version right? YOU TRICKED YOURSELF!!! TROLOLOLOOLOLOLOLOL \n");
				}else{
					start.text_1.append("Unknown command.\n");
				}
			}else{
				toserver.println(out);
			}
		} catch (Exception e) {
		}
		
	}
}
class listener implements Runnable{

	public String serverout;
	public void run() {
		boolean s = true, b = true;
		while(s == true){
			Scanner check;
			try {
				check = new Scanner(start.servercon.getInputStream()).useDelimiter("\\s*~\\s*");
				serverout = check.nextLine();
				if(serverout==null){
				s = false;
			}else{
				start.text_1.append(serverout+"\n");
				start.text_1.setCaretPosition(start.text_1.getDocument().getLength());
				System.out.println(serverout);
				System.out.println(serverout);
			}
			} catch (IOException e) {
			}catch(NullPointerException e1){		
			}catch(java.util.NoSuchElementException e2){
				while(b){
					start.text_1.append("Connection Lost or Server closed down. Pls Try Again Later.");
					b = false;
				}
			}catch(Exception a){                              
			}
			
			
		}
	}
}
