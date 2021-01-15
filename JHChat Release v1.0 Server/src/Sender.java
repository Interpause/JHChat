
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

class Sender{
	
	private static File file = null;
	
	private static PrintWriter write = null;
	
	public static void send(String string, Profile origin) {
		LinkedList<Profile> profiles = ProfileScanner.getList();
		for(Profile Person: profiles){
			Person.write(origin.getUsername()+": "+string.trim(),1);
		}	
		log(origin.getUsername()+": "+string.trim());
	}

	public static void send(String msg, String username) {
		Profile reciever = ProfileScanner.getProfile(username);
		reciever.write(msg.trim(),1);
		log("[PM to "+username+"]"+msg.trim());
		
	}
	
	public static void log(String msg){
		if(file == null){
			file = new File("./log-"+System.currentTimeMillis()+".txt");
		}
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if(write == null){
			try {
				write = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		write.println("["+System.currentTimeMillis()+"]: " + msg);
		System.out.println("["+System.currentTimeMillis()+"]: " + msg);
		Start.frame.textArea.append("["+System.currentTimeMillis()+"]: " + msg + "\n");
		Start.frame.textArea.setCaretPosition(Start.frame.textArea.getDocument().getLength());
		write.flush();
		
	}
	
	
}