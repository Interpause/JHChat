import java.net.Socket;
import java.util.ArrayList;





public class SocketContainer {
	public static ArrayList<Socket> sockets = new ArrayList<Socket>();
	private static Socket b;
	private static int a;
	
	public static void addSocket(Socket a){
		sockets.add(a);
		a=null;
	}
	public static ArrayList<Socket> getSockets(){
		return sockets;	
	}
	public static Socket getSocket(int i){
		return sockets.get(i);	
	}
	public static void setTempSocket(Socket s){
		SocketContainer.b=s;
	}
	public static Socket getTempSocket(){
		return b;
	}
	public static void RemoveSocket(int socket){
		sockets.remove(socket);
	}
	public static int Compare(Socket s){
		try{
			a=-1;
		for(Socket sock : sockets){
			a+=1;
			if(s==(sock)){
				return a;
			}
			
		}		
		}catch(Exception e){}
		return -1;
	}
}