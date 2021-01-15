import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class Communicator implements Runnable{
	private static PrintWriter write = null;
	private static Scanner read = null;
	@Override
	public void run() {
		try {
			write = new PrintWriter(SocketCreator.getSocket().getOutputStream(),true);
			read = new Scanner(new InputStreamReader(SocketCreator.getSocket().getInputStream()));
			read.useDelimiter("\n");

			while(true){
				
				String input="";
				try {
					if(read.hasNext()){
						input = read.next();
						System.out.println("Recieved: " + input);
						SocketCreator.Update();
					}else{
						read.close();
						ShutDown.shutDown();
						
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
					break;
					
				}
				System.out.println("Original: " + input);
				input = input.trim();
				InputFilter.filter(input);
				input = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ShutDown.shutDown();
			
		}
		
	}

	public static void refresh() {
		write.println("REFRESH@REFRESH");

	}
	
	
	/**
	 * mode 1 is msg and mode 2 is game.
	 */
	public static void write(String msg, int mode){
		msg = msg.trim();
		System.out.println("sending out in mode: "+mode+": " + msg);
		switch(mode){
		case 1:
			write.println("MSG@"+msg);
		break;
		case 2:
			write.println("GAME@"+msg);
		break;
		}
		
	}

}
