import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketEstablisher implements Runnable{
	ServerSocket host;
	Socket joined;
	@Override
	public void run() {
		GUI.viewer.append("SocketEstablisher V1 active.\n");
		try {
			host = new ServerSocket(50000);
		} catch (IOException e) {
		}
		while(true){
			try {
				joined=host.accept();
			} catch (Exception e) {
				GUI.viewer.append("ERROR! AT SOCKETESTABLISHER ACCEPTOR");
			}
			SocketContainer.setTempSocket(joined);
			SocketContainer.addSocket(joined);
			GUI.viewer.append("Connection established with "+joined.getRemoteSocketAddress().toString()+"\n");
			Thread t = new Thread(new ClientListener());
			t.start();
			PrivateSender.send(joined, "Today's MOTD is: " + Function.getMotd()+"\nGLOBALTEXT@Type /help for help.");
			Sender.send(joined.getRemoteSocketAddress().toString()+"joined.");
		}
	}

}
