import java.awt.EventQueue;
import java.io.*;
import java.net.*;
import java.util.*;
public class Starter {
	static String Solution,MOTD,comm,comout;
	static Socket cilentcon;
	static LinkedList<Socket> sockets = new LinkedList<Socket>();
	static boolean b1 = true;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(b1){
			b1 = Start.isDone();
			System.out.println(b1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
		}
		MOTD = Start.CallMotd();
		System.out.println(MOTD);
		try {
			@SuppressWarnings("resource")
			ServerSocket Host = new ServerSocket(50000);
			while(true){
				cilentcon = Host.accept();
				sockets.add(cilentcon);
				String cilentid = cilentcon.getInetAddress().toString();
				Start.Connection("Connection established with "+cilentid);
				Thread.sleep(1000);
				sout("Connection Established! Today's MOTD: "+MOTD);
				try{
				Thread p = null;
				Program a = new Program(cilentcon, cilentid,p);
				p = new Thread(a);
				p.start();
				}catch(Exception b){}
			}
		} catch (IOException c) {
			System.out.println("Network Exception. Pls check network cables, network stability and program contents.");
		}catch(InterruptedException e){
			
		}catch(Exception w){}
		
	}
	
	public static String InputReader(Socket servercon,String cilentid,Thread p){
		//Do no put thread.sleep here it breaks the client
		String serverout = "";
		try {
			@SuppressWarnings("resource")
			Scanner check = new Scanner(servercon.getInputStream()).useDelimiter("\\s*~\\s*");
			String unformat = check.nextLine();
			String Addon = cilentid + " TO [GLOBAL][CHAT]: ";
			serverout = Addon + unformat;
			Solution = serverout;
			} catch (Exception e) {

		}
		return serverout;
	}
	public static void sout(String out){
		try {
			PrintWriter toserver = new PrintWriter(cilentcon.getOutputStream(),true);
			toserver.println(out);
		} catch (Exception e) {
}
	}
	public static void output(String out,Socket servercon,Thread p){
		
		try {
			Socket rebelsock;
			Iterator<Socket> x = sockets.descendingIterator();
			while(x.hasNext()){
				rebelsock = x.next();
				PrintWriter toserver = new PrintWriter(rebelsock.getOutputStream(),true);
				toserver.println(out);
			}
			
		}catch(Exception e) {
		}
	}
	}
class listener implements Runnable{
	private Socket host;
	private String cilentid;
	private Thread p;
	static String serverout;
	public listener(Socket host,String cilentid, Thread p){
		this.host = host;
		this.cilentid = cilentid;
		this.p = p;
	}
	public void run() {
		while(true){
			
			Start.Chat(Starter.Solution);
			Starter.output(Starter.Solution,host,p);
			
		}
	}
}
class Program implements Runnable{
	private String cilentid;
	private Socket cilentcon;
	private Thread p;
	public Program(Socket cilentcon,String cilentid,Thread p){
		this.cilentcon=cilentcon;
		this.cilentid=cilentid;
		this.p = p;
	}
	public void run() {
		Thread listen = new Thread(new listener(cilentcon,cilentid,p));
		listen.start();
	}
}