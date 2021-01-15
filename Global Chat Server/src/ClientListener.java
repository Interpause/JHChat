import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientListener implements Runnable{
	private BufferedReader in;
	
	@Override
	public void run() {
		Socket s = SocketContainer.getTempSocket();
		GUI.viewer.append("Listening thread established with "+s.getRemoteSocketAddress().toString());
		Sender.send("GLOBALTEXT@"+s.getRemoteSocketAddress().toString()+" went on.");
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		while(true){
			String client="";
			String type = "";
			int where=1;
			try {
				client=in.readLine();
			} catch (Exception e) {
				
			}
			try{
			where = client.indexOf('@');
			}catch(Exception e1){}
			if(where!=-1){
				type = client.substring(0, where+1);
				client = client.substring(where+1,client.length());
				}
			
				if(type.equalsIgnoreCase("GLOBALTEXT@")){
					int where2 = -1;
					String game="", game2="";
					try{
						where2 = client.indexOf('~');
						}catch(Exception e1){}
						if(where2!=-1){
							System.out.println(client);
							game = client.substring(0, where2+1);
							game2 = client.substring(where2+1,client.length());
							System.out.println(game2);
							if(game.equals("~")){
								String hey = "";
								hey = GuessingGame.giveAns(game2);
								GUI.viewer.append(hey);
								PrivateSender.send(s, hey);
							}else{
								client = "GLOBALTEXT@"+"[GLOBAL][TEXT] "+s.getRemoteSocketAddress().toString()+":"+client;
								GUI.viewer.append(client+"\n");
								GUI.viewer.setCaretPosition(GUI.viewer.getDocument().getLength());
								Sender.send(client);
							}
						}else{
					client = "GLOBALTEXT@"+"[GLOBAL][TEXT] "+s.getRemoteSocketAddress().toString()+":"+client;
					GUI.viewer.append(client+"\n");
					GUI.viewer.setCaretPosition(GUI.viewer.getDocument().getLength());
					Sender.send(client);
							}
				}else if(type.equalsIgnoreCase("COMMAND@")){
					String command = "";
					if(client.equals("/help")){
						PrivateSender.send(s, "\nGLOBALTEXT@Commands:\nGLOBALTEXT@/info\nGLOBALTEXT@/trolled\nGLOBALTEXT@/GuessingGame");
						command="help";
					}else if(client.equals("/info")){
						PrivateSender.send(s, "JH Global Chat Client V3.\nGLOBALTEXT@Powered by JHTech.\nGLOBALTEXT@Beep.wav is from Growtopia.\nGLOBALTEXT@Programmed by John-Henry Lim\nGLOBALTEXT@All rights Reserved.");
						command="info";
					}else if(client.equalsIgnoreCase("/trolled")){
						PrivateSender.send(s, "YOU GOT TROLLED!!!");
						Sender.send("GLOBALTEXT@"+s.getRemoteSocketAddress().toString()+" GOT TROLLED!!!");
						command="trolled";
					}else if(client.equalsIgnoreCase("/secret")){
						PrivateSender.send(s, "Great job finding this useless command!");
						command="secret";
					}else if(client.equalsIgnoreCase("/GuessingGame")){
						command="Guessing Game";
						Sender.send("Guessing Game V1 has been initiated by "+s.getRemoteSocketAddress().toString()+". If you want to join in, write an answer by puting ~ before your answer!");
						PrivateSender.send(s, "Initiating Guessing Game V1... Before writing your answer put ~.");
						PrivateSender.send(s, GuessingGame.Run());
					}else{
						PrivateSender.send(s, "The command you sent is unknown, do /help for commands.");
						command="unknown";
					}
					GUI.viewer.append(s.getRemoteSocketAddress().toString()+" used "+command+" command.");
				}else if(type.equalsIgnoreCase("SYSTEM@")){
					if(client.equalsIgnoreCase("SHUTDOWN")){
						Sender.send("GLOBALTEXT@"+s.getRemoteSocketAddress().toString()+" used went off.");
						GUI.viewer.append("\n"+s.getRemoteSocketAddress().toString()+" used went off.");
						int a = SocketContainer.Compare(s);
						if(!(a==-1)){
						SocketContainer.RemoveSocket(a);
						}
					
				}
			}
			
			}
			
		}
	}


