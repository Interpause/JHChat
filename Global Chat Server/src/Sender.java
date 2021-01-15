import java.io.PrintWriter;
import java.net.Socket;


public class Sender {
	private static PrintWriter toserver;
	static void send(String s){
		try{
			for(Socket socket : SocketContainer.getSockets()){
				toserver = new PrintWriter(socket.getOutputStream(),true);
				toserver.println(s);
		}
		}catch(Exception e){
		}
	}
}
