import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Establisher implements Runnable{
	PrintWriter tempWrite;
	Scanner tempRead;
	private int where;
	private Listener temp;
	private String msg, username, password, type;
	private Socket socket;
	private boolean isDone = false, isUpdated = false;
	public String motd = "Welcome to this server!";

	@Override
	public void run() {
		while(socket==null){
			
		}
		
		try {
			tempRead = new Scanner(new InputStreamReader(socket.getInputStream()));
			tempRead.useDelimiter("\n");
			tempWrite = new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
			Sender.log(e.toString());
		}
		motd = Start.frame.motd;
		tempWrite.println("MSG@"+motd);
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(!isDone){
					try {
						Thread.sleep(4500);
					} catch (InterruptedException e) {
						
					}
					tempWrite.write("REFRESH@LOL\n");
				}
				
			}
			
		}).start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(!isDone){
					try {
						Thread.sleep(1000);
						if(!isUpdated){
							isDone=true;
							System.out.println("Client disconnected during setup.");
						}
						isUpdated=false;
					} catch (InterruptedException e) {
					
					}
					tempWrite.write("REFRESH@LOL\n");
				}
				
			}
			
		}).start();
		while(true){
			if(isDone){
				break;
			}
			where = -1;
			temp = null;
			msg = "";
			username = "";
			password = "";
			type = "";
			
			tempWrite.println("MSG@"+"Pls login by typing in your username. If it does not exist, we will automatically create a new account.");
			while(true){
				if(isDone){
					break;
				}
				if(tempRead.hasNext()){
					if(isDone){
						break;
					}
					msg = tempRead.next();
					where = msg.indexOf('@');
					if(where != -1){
						type = msg.substring(0, where+1);
						msg = msg.substring(where+1,msg.length());
						if(type.equalsIgnoreCase("MSG@")){
							username = msg.trim();	
							isUpdated = true;
							break;
					}else if(type.equalsIgnoreCase("REFRESH@")){
						isUpdated = true;
					}
				}
				}
				
			}
			tempWrite.println("MSG@"+"Now type your pass.");
			while(true){
				if(isDone){
					break;
				}
				if(tempRead.hasNext()){
					if(isDone){
						break;
					}
					msg = tempRead.next();
					where = msg.indexOf('@');
					if(where != -1){
						type = msg.substring(0, where+1);
						msg = msg.substring(where+1,msg.length());
						if(type.equalsIgnoreCase("MSG@")){
							password = msg.trim();	
							isUpdated = true;
							break;
					}else if(type.equalsIgnoreCase("REFRESH@")){
						isUpdated = true;
					}
				}
			}
			}
			
				if(ProfileScanner.getUsernamePass(username)!= null){
					if(password.equals(ProfileScanner.getUsernamePass(username))){
						ProfileScanner.getProfile(username).setSocket(socket);
						temp = new Listener();
						temp.setProfile(ProfileScanner.getProfile(username));
						ProfileScanner.getProfile(username).setListener(new Thread(temp));
						ProfileScanner.getProfile(username).write("Hello, "+username, 1);
						isDone = true;
						Sender.log(socket.getRemoteSocketAddress().toString()+" has logged in as "+username);
						break;
					}else{
						tempWrite.println("MSG@"+"Password for account is wrong. Pls try again.");
					}
				}else{
					ProfileScanner.addProfileToDatabase(username, password);
					System.out.println("New profile "+username+" added.");
					ProfileScanner.getProfile(username).setSocket(socket);
					System.out.println(username+"'s socket passed over.");
					temp = new Listener();
					System.out.println(username+"'s listener created.");
					temp.setProfile(ProfileScanner.getProfile(username));
					System.out.println(username+"'s listener master set.");
					ProfileScanner.getProfile(username).setListener(new Thread(temp));
					System.out.println(username+"'s listener passed over.");
					ProfileScanner.getProfile(username).write("Hello, "+username, 1);
					System.out.println(username+" has been greeted.");
					isDone = true;
					System.out.println(username+" is done!");
					Sender.log(socket.getRemoteSocketAddress().toString()+" has logged in as "+username);
					break;
				}
			
			}
		
		
		
	}
	
	public void setReady(Socket socket){
		this.socket = socket;
	}

}
