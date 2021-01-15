import java.awt.EventQueue;


public class Start {
	public static frame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					Sender.log(e.toString());
				}
			}
		});
		ProfileScanner.scan();
		new Thread(new SocketEstablisher()).start();
		ProfileScanner.addProfileToDatabase("SYSTEM", "osnfdhosajfbndsaofjbsdf");
	}

}
