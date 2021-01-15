import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketCreator {
	private static Socket connection;
	private static Thread t;
	private static Thread t2;
	private static Thread t3;
	private static PacketReceiver Re;
	public static boolean isUpdated = false;
	public static boolean createSocket(String ip){
		Main.setButtonEnabled(false);
		Main.write("Connecting...");
		try {
			connection = new Socket(ip,50000);			
		} catch (UnknownHostException e) {
			Main.write("Sorry, the ip you typed in does not match standard formats or we cant connect to ip. Format should be: n.n.n.n");
			ShutDown.shutDown();
			return false;
		} catch (IOException e) {
			Main.write("Sorry, an error occurred when connecting to the ip. Pls try again.");
			ShutDown.shutDown();
			return false;
		}catch (Exception e){
			Main.write("Somethings wrong?");
			ShutDown.shutDown();
			return false;
		}
		Main.setButtonEnabled(true);
		Main.setButtonFunc(true);
		t = new Thread(new Communicator());
		t.start();
		t3 = new Thread(new PacketSender());
		t3.start();
		t2 = new Thread(Re);
		t2.start();
		return true;
		
	}
	
	public static Socket getSocket(){
		return connection;
	}
	
	public static void Reset(){
		
		
		try{
			t.interrupt();
			t2.interrupt();
			t3.interrupt();
		}catch(Exception e){
			e.printStackTrace();
		}
		t = null;
		t2 = null;
		t3 = null;
		try {
			connection.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		connection = null;
	}
	
	public static void Update(){
		isUpdated = true;
	}
}
