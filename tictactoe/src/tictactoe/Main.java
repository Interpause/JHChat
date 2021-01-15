package tictactoe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9033852491650822861L;
	private JPanel contentPane;
	public static JButton btn1;
	public static JButton btn2;
	public static JButton btn3;
	public static JButton btn4;
	public static JButton btn5;
	public static JButton btn6;
	public static JButton btn7;
	public static JButton btn8;
	public static JButton btn9;
	public static JButton playone;
	public static JButton playtwo;
	public static JButton btnExit;
	public static JButton[] btnarray = new JButton[9];
	public boolean turn = true, play = false;
	public static boolean done = true, won = true;
	static JTextField txt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread t = new Thread(new game());
		t.start();
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("TickTackToe");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JButton();
		btn1.setEnabled(false);
		btn1.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn1.setBounds(0, 0, 100, 100);
		btn1.addActionListener(this);
		btnarray[0]=btn1;
		contentPane.add(btn1);
		
		btn2 = new JButton();
		btn2.setEnabled(false);
		btn2.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn2.setBounds(99, 0, 100, 100);
		btn2.addActionListener(this);
		btnarray[1]=btn2;
		contentPane.add(btn2);
		
		btn3 = new JButton();
		btn3.setEnabled(false);
		btn3.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn3.setBounds(198, 0, 100, 100);
		btn3.addActionListener(this);
		btnarray[2]=btn3;
		contentPane.add(btn3);
		
		btn4 = new JButton();
		btn4.setEnabled(false);
		btn4.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn4.setBounds(0, 100, 100, 100);
		btn4.addActionListener(this);
		btnarray[3]=btn4;
		contentPane.add(btn4);
		
		btn5 = new JButton();
		btn5.setEnabled(false);
		btn5.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn5.setBounds(99, 100, 100, 100);
		btn5.addActionListener(this);
		btnarray[4]=btn5;
		contentPane.add(btn5);
		
		btn6 = new JButton();
		btn6.setEnabled(false);
		btn6.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn6.setBounds(198, 100, 100, 100);
		btn6.addActionListener(this);
		btnarray[5]=btn6;
		contentPane.add(btn6);
		
		btn7 = new JButton();
		btn7.setEnabled(false);
		btn7.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn7.setBounds(0, 200, 100, 100);
		btn7.addActionListener(this);
		btnarray[6]=btn7;
		contentPane.add(btn7);
		
		btn8 = new JButton();
		btn8.setEnabled(false);
		btn8.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn8.setBounds(99, 200, 100, 100);
		btn8.addActionListener(this);
		btnarray[7]=btn8;
		contentPane.add(btn8);
		
		btn9 = new JButton();
		btn9.setEnabled(false);
		btn9.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn9.setBounds(198, 200, 100, 100);
		btn9.addActionListener(this);
		btnarray[8]=btn9;
		contentPane.add(btn9);
		
		txt = new JTextField();
		txt.setText("Choose Gamemode");
		txt.setEditable(false);
		txt.setBounds(0, 311, 298, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		playone = new JButton("1 player");
		playone.setFont(new Font("Arial", Font.PLAIN, 12));
		playone.setBounds(0, 342, 89, 23);
		playone.addActionListener(this);
		contentPane.add(playone);
		
		playtwo = new JButton("2 player");
		playtwo.setFont(new Font("Arial", Font.PLAIN, 12));
		playtwo.setBounds(209, 342, 89, 23);
		playtwo.addActionListener(this);
		contentPane.add(playtwo);
		
		btnExit = new JButton("exit");
		btnExit.setBounds(209, 406, 89, 23);
		btnExit.addActionListener(this);
		contentPane.add(btnExit);
		
		JLabel lblPoweredByJhtech = new JLabel("Powered by JHTech");
		lblPoweredByJhtech.setBounds(0, 410, 127, 14);
		contentPane.add(lblPoweredByJhtech);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() != playone && e.getSource() != playtwo && e.getSource() != btnExit){
		JButton subject = (JButton)e.getSource();
		if(!(subject.getText().equals("x")||subject.getText().equals("o"))){
		if(play){
		if(turn){
			subject.setText("x");
			txt.setText("Player 2's turn! Make Your Move.");
			turn = !turn;
		}else{
			subject.setText("o");
			txt.setText("Player 1's turn! Make Your Move.");
			turn = !turn;
		}
		}else{
			if(done){
			subject.setText("x");
			txt.setText("Computer's turn! Calculating...");
			Thread a = new Thread(new computer());
			done = false;
			a.start();
			won=true;
			}
		}
		}
		}else if(e.getSource()==playtwo){
			play = true;
			turn = true;
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
			btn4.setEnabled(true);
			btn5.setEnabled(true);
			btn6.setEnabled(true);
			btn7.setEnabled(true);
			btn8.setEnabled(true);
			btn9.setEnabled(true);
			playone.setEnabled(false);
			playtwo.setEnabled(false);
			txt.setText("Player 1's turn! Make Your Move.");
		}else if(e.getSource()==playone){
			turn = true;
			play = false;
			done=true;
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
			btn4.setEnabled(true);
			btn5.setEnabled(true);
			btn6.setEnabled(true);
			btn7.setEnabled(true);
			btn8.setEnabled(true);
			btn9.setEnabled(true);
			playone.setEnabled(false);
			playtwo.setEnabled(false);
			playone.setEnabled(false);
			playtwo.setEnabled(false);
			txt.setText("Player 1's turn! Make Your Move.");
	}else if (e.getSource()==btnExit){
		System.exit(0);
	}
}
}
class game implements Runnable{

@Override
public void run() {
	while(true){
		try{
		if(Main.btn1.getText().equals("x")&&Main.btn2.getText().equals("x")&&Main.btn3.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn4.getText().equals("x")&&Main.btn5.getText().equals("x")&&Main.btn6.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn7.getText().equals("x")&&Main.btn8.getText().equals("x")&&Main.btn9.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn1.getText().equals("x")&&Main.btn4.getText().equals("x")&&Main.btn7.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn2.getText().equals("x")&&Main.btn5.getText().equals("x")&&Main.btn8.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn3.getText().equals("x")&&Main.btn6.getText().equals("x")&&Main.btn9.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn1.getText().equals("o")&&Main.btn2.getText().equals("o")&&Main.btn3.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn4.getText().equals("o")&&Main.btn5.getText().equals("o")&&Main.btn6.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn7.getText().equals("o")&&Main.btn8.getText().equals("o")&&Main.btn9.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn1.getText().equals("o")&&Main.btn4.getText().equals("o")&&Main.btn7.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn2.getText().equals("o")&&Main.btn5.getText().equals("o")&&Main.btn8.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn3.getText().equals("o")&&Main.btn6.getText().equals("o")&&Main.btn9.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn1.getText().equals("x")&&Main.btn5.getText().equals("x")&&Main.btn9.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn3.getText().equals("x")&&Main.btn5.getText().equals("x")&&Main.btn7.getText().equals("x")){
			JOptionPane.showMessageDialog(null, "Player 1 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 1 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn1.getText().equals("o")&&Main.btn5.getText().equals("o")&&Main.btn9.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if(Main.btn3.getText().equals("o")&&Main.btn5.getText().equals("o")&&Main.btn7.getText().equals("o")){
			JOptionPane.showMessageDialog(null, "Player 2 wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("Player 2 Won!");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}else if((Main.btn1.getText().equals("o")||Main.btn1.getText().equals("x"))&&(Main.btn2.getText().equals("o")||Main.btn2.getText().equals("x"))&&(Main.btn3.getText().equals("o")||Main.btn3.getText().equals("x"))&&(Main.btn4.getText().equals("o")||Main.btn4.getText().equals("x"))&&(Main.btn5.getText().equals("o")||Main.btn5.getText().equals("x"))&&(Main.btn6.getText().equals("o")||Main.btn6.getText().equals("x"))&&(Main.btn7.getText().equals("o")||Main.btn7.getText().equals("x"))&&(Main.btn8.getText().equals("o")||Main.btn8.getText().equals("x"))&&(Main.btn9.getText().equals("o")||Main.btn9.getText().equals("x"))){
			JOptionPane.showMessageDialog(null, "No one wins.", "...", JOptionPane.INFORMATION_MESSAGE);
			Main.txt.setText("No one won.");
			Main.btn1.setText("");
			Main.btn2.setText("");
			Main.btn3.setText("");
			Main.btn4.setText("");
			Main.btn5.setText("");
			Main.btn6.setText("");
			Main.btn7.setText("");
			Main.btn8.setText("");
			Main.btn9.setText("");
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			Main.playone.setEnabled(true);
			Main.playtwo.setEnabled(true);
			Main.won=false;
		}
	}catch(Exception e){}
	}
}
}
class computer implements Runnable{

	@Override
	public void run() {
		boolean checkdone=false, notDone=true;
			Main.btn1.setEnabled(false);
			Main.btn2.setEnabled(false);
			Main.btn3.setEnabled(false);
			Main.btn4.setEnabled(false);
			Main.btn5.setEnabled(false);
			Main.btn6.setEnabled(false);
			Main.btn7.setEnabled(false);
			Main.btn8.setEnabled(false);
			Main.btn9.setEnabled(false);
			int i = 0;
			while(notDone){
				if(Main.btnarray[i].getText().equals("o")||Main.btnarray[i].getText().equals("x")){
				//}else if(true){
				}else{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					Main.btnarray[i].setText("o");
					Main.txt.setText("Player 1's turn! Make Your Move.");
					checkdone=true;
					Main.done=true;
					notDone=false;
				}
				i++;
			}
			
			Main.btn1.setEnabled(true);
			Main.btn2.setEnabled(true);
			Main.btn3.setEnabled(true);
			Main.btn4.setEnabled(true);
			Main.btn5.setEnabled(true);
			Main.btn6.setEnabled(true);
			Main.btn7.setEnabled(true);
			Main.btn8.setEnabled(true);
			Main.btn9.setEnabled(true);
		}
	}


