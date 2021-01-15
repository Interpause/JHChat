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
				}
				
			}
			
			try {
				br = new BufferedReader(new FileReader(file));
				write = new PrintWriter(new FileWriter(file, true));
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String username = "";
			String password = "";
			String information;
			int Times = 0;
			try {
				
				CryptoUtils.decrypt("abcdefghijklmno1", file, file);
				while((information = br.readLine())!= null){
						Times++;
						if(Times%2==1){
						
							username = information;
							information = null;
						}else if(Times%2==0){
						
							password = information;
							if(getProfile(username)!=null){
								break;
							}
							profiles.add(new Profile(username, password, noprofiles++));
							
							username = "";
							password = "";
							information = null;
							
							
						}
					
						
				}
						
						
						
							
							CryptoUtils.encrypt("abcdefghijklmno1", file, file);
							
						
						
						
						
						
						
						
					
				
			} catch (IOException | CryptoException e) {
				
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
	public static void addProfileToDatabase(String Username, String Password){
		try {
			CryptoUtils.decrypt("abcdefghijklmno1", file, file);
	
		write.println(Username);
		write.println(Password);
		write.flush();
		profiles.add(new Profile(Username, Password, noprofiles++));
		CryptoUtils.encrypt("abcdefghijklmno1", file, file);
		} catch (CryptoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(){
		write.close();
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
