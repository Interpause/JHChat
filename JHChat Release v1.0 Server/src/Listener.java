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
	
	@Override
	public void run() {
		while(!hasSet){
		}
		try {
			new Thread(new Runnable(){

				@Override
				public void run() {
					while(true){
					try{
						Thread.sleep(1000);
						if(!Updated){
							if(profile.getOnline()){
								profile.shutDown();
								off=true;
								break;
							}
							off=true;
							break;
						}
						Updated = false;
					}catch(Exception e){
						e.printStackTrace();
					}
					}
					
				}
				
			}).start();
			in = new Scanner(new InputStreamReader(socket.getInputStream()));
			in.useDelimiter("\n");
			System.out.println("Listener Set up.");
			hasSet = true;
			
		} catch (IOException e) {
			e.printStackTrace();
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
			
				PacketManager.update(profile);
				where = msg.indexOf('@');
				if(where != -1){
					type = msg.substring(0, where+1);
					msg = msg.substring(where+1,msg.length());
					msg = msg.trim();
					type = type.trim();
				
				
			
				if(type.equalsIgnoreCase("MSG@")){
					if(msg.indexOf('/')==0){
						
						CommandHandler.handle(msg, profile);
						
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
		}
		in.useDelimiter("\n");
		hasSet = true;
	}
}
