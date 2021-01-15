import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


public class ProfileScanner {
	static BufferedReader br;
	static PrintWriter write;
	static int where1;
	static int where2;
	static int ID;
	static int noprofiles=0;
	static String Username, Password, unprocessed, halfprocessed;
	static File file;
	static LinkedList<Profile> profiles = new LinkedList<Profile>();
	public static void scan(){
			file = new File("./database.txt");
			if(!file.isFile()){
				try {
					file.createNewFile();
					CryptoUtils.encrypt("abcdefghijklmno1", file, file);
				} catch (IOException | CryptoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Sender.log(e.toString());
				}
				
			}
			
			try {
				br = new BufferedReader(new FileReader(file));
				write = new PrintWriter(new FileWriter(file, true));
				
			} catch (IOException e1) {
				e1.printStackTrace();
				Sender.log(e1.toString());
			}
			String username = "";
			String password = "";
			String information;
			int Times = 0, where = -1, wins = 0;
			try {
				
				CryptoUtils.decrypt("abcdefghijklmno1", file, file);
				while((information = br.readLine())!= null){
						Times++;
						if(Times%2==1){
						
							
							where = information.indexOf(',');
							if(where != -1){
								username = information.substring(0, where);
								username = username.trim();
								wins = Integer.parseInt(information.substring(where+1,information.length()).trim());
							}else{
								username = information.trim();
							}
							information = null;
						}else if(Times%2==0){
						
							password = information;
							if(getProfile(username)!=null){
								break;
							}
							Profile a = new Profile(username, password, noprofiles++);
							a.setTicTacToeWins(wins);
							profiles.add(a);
							
							username = "";
							password = "";
							information = null;
							
							
						}
					
						
				}
						
						
						
							
							CryptoUtils.encrypt("abcdefghijklmno1", file, file);
							
						
						
						
						
						
						
						
					
				
			} catch (IOException | CryptoException e) {
				Sender.log(e.toString());
				e.printStackTrace();
				
			}
		
	}
	public static LinkedList<Profile> getList(){
		return profiles;
	}
	/**
	 * Returns null if profile doesnt not exist.
	 */
	public static String getUsernamePass(String Username){
		for(Profile check:profiles){
			if(check.getUsername().equals(Username)){
				return check.getPassword();
			}
		}
		return null;
	}
	public static void removeProfile(String Username){
		for(Profile check:profiles){
			if(check.getUsername().equals(Username)){
				profiles.remove(check);
			}
		}
	}
	/**
	 * Returns null if profile doesnt not exist.
	 */
	public static Profile getProfile(String Username){
		for(Profile check:profiles){
			if(check.getUsername().equals(Username)){
				return check;
			}
		}
		return null;
	}
	public static void addProfileToDatabase(String Username, String Password, int wins){
		try {
			CryptoUtils.decrypt("abcdefghijklmno1", file, file);
	
		write.println(Username+","+wins);
		write.println(Password);
		write.flush();
		profiles.add(new Profile(Username, Password, noprofiles++));
		CryptoUtils.encrypt("abcdefghijklmno1", file, file);
		} catch (CryptoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Sender.log(e.toString());
		}
	}
	
	public static void close(){
		write.close();
		try {
			br.close();
		} catch (IOException e) {
			Sender.log(e.toString());
			e.printStackTrace();
		}catch(NullPointerException e1){
			e1.printStackTrace();
		}
	}
	
	public static void save(){
		try {
			CryptoUtils.decrypt("abcdefghijklmno1", file, file);
		} catch (CryptoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		close();
		file.delete();
		try {
			file.createNewFile();
			write = new PrintWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Profile check:profiles){
			write.println(check.getUsername()+","+check.getTicTacToeWins());
			write.println(check.getPassword());
			write.flush();
		}
		try {
			CryptoUtils.encrypt("abcdefghijklmno1", file, file);
		} catch (CryptoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	
	}
}
