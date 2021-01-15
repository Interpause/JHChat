import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class SocketCreator {
	
	public static Socket connection;
	public static boolean active=false;
	
	public static Socket getSocket(){
		if(connection==null){
			try {
				connection = new Socket(ipRetriever.getIp(),50000);
				Thread t = new Thread(new SocketListener());
				t.start();
				Thread t2 = new Thread(new packetChecker());
				t2.start();
				GuiFrame.viewer.append("Connected!\n");
				active=true;
				GuiFrame.btnSetIp.setEnabled(true);
			} catch (UnknownHostException e) {
				GuiFrame.viewer.append("The Host is Unknown. Pls try again later.\n");
				GuiFrame.btnSetIp.setEnabled(true);
				GuiFrame.send.setEnabled(false);
				active=false;
			} catch (IOException e) {
				GuiFrame.viewer.append("The Connection is Unstable or got interrupted. Pls try again later.\n");
				GuiFrame.btnSetIp.setEnabled(true);
				GuiFrame.send.setEnabled(false);
				active=false;
			}
		}
		
		return connection;
		
	}
	public static void setActive(boolean online){
		active=online;
		}
	public static boolean isActive(){
		return active;
	}
	}

