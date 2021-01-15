import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class PrivateSender {
	private static PrintWriter toserver;
	private static String type="GLOBALTEXT@";
	public static void send(Socket joined, String b){
		GUI.viewer.append(b+"\n");
		try {
			toserver = new PrintWriter(joined.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toserver.println(type+b);
	}
	public static void setType(String a){
		type=a;
	}
}
