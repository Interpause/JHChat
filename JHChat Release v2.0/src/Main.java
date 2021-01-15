import java.awt.EventQueue;


public class Main {
	private static Frame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	public static void write(String Write){
		frame.write(Write);
	}
	
	public static void setTTTButton(int btn, char letter){
		frame.setTTTButton(btn, letter);
	}
	
	public static void setTTTMode(boolean active){
		frame.setTTTMode(active);
	}
	
	public static void TTTClear(){
		frame.TTTClear();
	}
	
	public static void setButtonEnabled(boolean a){
		frame.setButtonEnabled(a);
	}
	public static void setButtonFunc(boolean a){
		frame.setButtonFunc(a);
	}
}
