import java.io.IOException;
import java.io.PrintWriter;


public class SocketSender{
	public static int type=0;
	static PrintWriter toserver;
	public static void send(String goingout) {
		try {
			toserver = new PrintWriter(SocketCreator.getSocket().getOutputStream(),true);
		} catch (IOException e1) {
		}
		switch(type){
		case 0:
			toserver.println("GLOBALTEXT@"+goingout);
			break;
		case 1:
			toserver.println("COMMAND@"+goingout);
		case 2:
			toserver.println("SYSTEM@"+goingout);
		}
	}
	public static void setSendValue(int a){
		SocketSender.type=a;
	}
}
