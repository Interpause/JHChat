
public class ShutDown {
	public static void shutDown(){
		Main.setButtonEnabled(true);
		
		Main.write("Connection Lost! Pls reconnect.");
	
		Main.setButtonFunc(false);
		SocketCreator.Reset();
	}
}
