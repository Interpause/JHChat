import java.io.*;
import java.net.*;
import java.util.*;

public class Starter {
	static int port =50000;
	static Scanner sc = new Scanner(System.in).useDelimiter("\\s*~\\s*");
	static Socket servercon1;
	public static void main(String[] args) {
		boolean test1=true;
		do{
			servercon1 = connector();
			if(servercon1 == null){
				break;
			}	
			Thread listen = new Thread(new listener());
			listen.start();
			Thread write = new Thread(new writer());
			write.start();
			while(true){
				boolean test3 = write.isInterrupted();
				if(test3 == true){
					break;
				}
			}
		}while(!test1);
		System.out.println("Thanks for using JH's Global Chat Program V1.");
	}
	public static void output(String out,Socket servercon){
		try {
			PrintWriter toserver = new PrintWriter(servercon.getOutputStream(),true);
			toserver.println(out);
		}catch(Exception e) {
			System.out.println("An error has occurred. Pls try again later.");			
		}
	}
	
	public static Socket connector(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWelcome to JH's Global Chat Program V1.\nPowered by JHTech. All rights reserved.");
		while(true){
			System.out.println("Connecting...");
			try{
				String ip = "192.168.0.33";
				Socket servercon = new Socket(ip,port);
				System.out.println("Connection Established!\nReady to Chat!");
				return servercon;
			}catch(Exception e){
					System.out.println("A network error has occured. Retry?(Yes/No)");
					String string1 = sc.nextLine();
					if(string1.equalsIgnoreCase("yes")){
					}else if(string1.equalsIgnoreCase("no")){
						break;
					}else{
						System.out.println("Input invalid. Opting for retry.");
					}
			}
		}
		return null;
	}
	
	public static String InputReader(Socket servercon){
		String serverout = null;
		try {
			@SuppressWarnings("resource")
			Scanner check = new Scanner(servercon.getInputStream()).useDelimiter("\\s*~\\s*");
			serverout = check.nextLine();
		} catch (Exception e) {
			System.out.println("Connection timed out. Pls try again later.");
			System.exit(0);
		}
		return serverout;
	}
}
class listener implements Runnable{

	
	public void run() {
		boolean s = true;
		while(s == true){
			String serverout = Starter.InputReader(Starter.servercon1);
			if(serverout==null){
				s = false;
			}else{
			System.out.println(serverout);
			}
		}
	}
}
class writer implements Runnable{
	public void run(){
		String string2;
		while(true){
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in).useDelimiter("\\s*~\\s*");
			string2 = sc.nextLine();
			if(string2.equals("EXIT")){
				break;
			}
			Starter.output(string2,Starter.servercon1);
		}
}
}
