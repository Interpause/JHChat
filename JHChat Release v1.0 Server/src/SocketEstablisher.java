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
			return;
		}
		
		while(true){
			try {
				joined=host.accept();
				System.out.println("SOMEONES JOINGIN");
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			est = new Establisher();
			est.setReady(joined);
			new Thread(est).start();
		}
	}

}
