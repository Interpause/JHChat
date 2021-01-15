import java.net.ServerSocket;
import java.net.Socket;


public class SocketEstablisher implements Runnable{
	ServerSocket host;
	Socket joined;
	Establisher est;
	@Override
	public void run() {
		try {
			host = new ServerSocket(50000);
		} catch (Exception e) {
			e.printStackTrace();
			Sender.log(e.toString());
			return;
		}
		
		while(true){
			try {
				joined=host.accept();
				Sender.log(joined.getRemoteSocketAddress().toString() + " has connected to server.");
			} catch (Exception e) {
				e.printStackTrace();
				Sender.log(e.toString());
				break;
			}
			est = new Establisher();
			est.setReady(joined);
			new Thread(est).start();
		}
	}

}
