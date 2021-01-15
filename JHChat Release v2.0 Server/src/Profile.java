import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Profile {
	private String Username,Password;
	private int ID;
	private Thread Listener,manager;
	private Socket socket;
	private PrintWriter write;
	private boolean isActive = false;
	
	public Profile(String Username, String Password, int ID){
		this.Username = Username;
		this.Password = Password;
		this.ID = ID;
		isActive = false;
		//while(true){
			//if(socket != null){
				//if(socket.isClosed()){
				//	System.out.println(Username + "'s socket has closed.");
					//break;
				//}
			//}
	//	}
	}
	
	public String getUsername(){
		return Username;
	}
	
	public String getPassword(){
		return Password;
	}
	
	public int getID(){
		return ID;
	}
	
	
	
	public Socket getSocket(){
		Sender.send(Username + " went online.",ProfileScanner.getProfile("SYSTEM"));
		return socket;
	}
	
	public void setSocket(Socket socket){
		isActive = true;
		this.socket=socket;
	}
	/**
	 * 1 is msg 2 is game 3 is command 4 is refresh
	 */
	public void write(String output, int mode){
		if(socket!=null){
			try {
				write = new PrintWriter(socket.getOutputStream(),true);
			} catch (IOException e) {
				e.printStackTrace();
				Sender.log(e.toString());
			}
			switch(mode){
				case 1: 
					write.println("MSG@"+output);
					Sender.log("Msg sent to "+Username+": "+output);
					break;
				case 2: 
					write.println("GAME@"+output);
					break;
				case 3: 
					write.println("COMMAND@"+output);
					break;
				case 4: 
					write.println("REFRESH@"+output);
					break;
			}
		}
	}
	
	public void setListener(Thread Listener){
		this.Listener = Listener;
		isActive = true;
		Listener.start();
	}
	
	public Thread getListener(){
		return Listener;
	}
	

	
	public void setPacketManager(Thread manager){
		this.manager = manager;
		isActive = true;
	}
	
	public boolean getOnline(){
		return isActive;
	}
	
	public Thread getManager(){
		return manager;
	}
	
	public void shutDown(){
		System.out.println(Username + "'s socket closing.");
		isActive = false;
		try {
			
			write("RESET", 2);
			write("DISCONNECT", 3);
			Sender.send(Username + " has went offline.",ProfileScanner.getProfile("SYSTEM"));
			
			
			Listener.interrupt();
			write.close();
			socket.close();
			socket = null;
		} catch (Exception e) {
			e.printStackTrace();
			Sender.log(e.toString());
		}
		
	}
	
	
}
