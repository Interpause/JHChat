import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class Listener implements Runnable{
	private Scanner in;
	private boolean Updated = false, off=false;
	private Socket socket;
	private Profile profile;
	private String msg, type;
	private int where = -1;
	private boolean hasSet=false;
	private Thread a;
	private CommandHandler handle;
	@Override
	public void run() {
		while(!hasSet){
		}
		
		try {
			a = new Thread(new Runnable(){

				@Override
				public void run() {
					handle = new CommandHandler();
					while(true){
					try{
						if(profile.doIShutDown()){
							break;
						}
						
						Thread.sleep(10000);
						if(profile.doIShutDown()){
							break;
						}
			
							if(!Updated&&!profile.doIShutDown()){
								Sender.log(profile.getUsername()+ " is inactive. Shutting down now...");
								profile.shutDown();
								
								off=true;
								break;
							
								
							
							
							}
						if(profile.doIShutDown()){
							break;
						}
						Updated = false;
					}catch(Exception e){
						e.printStackTrace();
					}
					}
					
				}
				
			});
			a.start();

			in = new Scanner(new InputStreamReader(socket.getInputStream()));
			in.useDelimiter("\n");
			System.out.println("Listener Set up.");
			hasSet = true;
			
		} catch (IOException e) {
			e.printStackTrace();
			Sender.log(e.toString());
		}
		while(true){
			if(off){
				break;
			}
			msg = "";
			type = "";
			where = -1;
			if(in.hasNext()&&off==false){
				msg = in.next();
				msg = msg.trim();
				Updated = true;
				PacketManager.update(profile);
				where = msg.indexOf('@');
				if(where != -1){
					type = msg.substring(0, where+1);
					msg = msg.substring(where+1,msg.length());
					msg = msg.trim();
					type = type.trim();
				
				
			
				if(type.equalsIgnoreCase("MSG@")){
					if(msg.indexOf('/')==0){
						
						handle.handle(msg, profile);
						
					}else{
						
						Sender.send(msg, profile);
						
					}
				}else if(type.equalsIgnoreCase("GAME@")){
					ActiveTTT.play(profile, Integer.parseInt(msg));
					
				}else if(type.equalsIgnoreCase("REFRESH@")){
					
					Updated = true;
				}
				}
			}
		}
		
		
	}
	
	public void setProfile(Profile profile){
		this.socket = profile.getSocket();
		if(this.socket == null){
			System.out.println("Socket is missing!?!");
		}
		this.profile = profile;
		try {
			in = new Scanner(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Sender.log(e.toString());
		}
		in.useDelimiter("\n");
		hasSet = true;
	}
}
