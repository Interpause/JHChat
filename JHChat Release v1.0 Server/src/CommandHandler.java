
public class CommandHandler {
	static int where = -1;
	static String type, secondmsg;
	public static void handle(String msg, Profile profile) {
		type = "";
		where = -1;
		secondmsg = "";
		where = msg.indexOf(' ');
		if(where != -1){
			type = msg.substring(0, where);
			secondmsg = msg.substring(where+1, msg.length());
			secondmsg.trim();
			System.out.println("Starting Game with"+secondmsg);
		}else{
			type = msg;
		}
		if(type.equalsIgnoreCase("/help")){
			profile.write("Current commands available are: /help and /TicTacToe and /online", 1);
		}else if(type.equalsIgnoreCase("/TicTacToe")){
			ProfileScanner.getProfile(secondmsg).write(profile.getUsername()+" wants to play tictactoe with you. Activating Screen... to quit do /quit", 1);
			new TTTHandler(profile,ProfileScanner.getProfile(secondmsg));
		}else if(type.equalsIgnoreCase("/online")){
			for(Profile p:ProfileScanner.getList()){
				if(p.getOnline()){
					profile.write(p.getUsername(), 1);
				}
			}
		}else if(type.equalsIgnoreCase("/quit")){
			if(ActiveTTT.getTTTHandler(profile)!=null){
				ActiveTTT.getTTTHandler(profile).getPlayer2().write("Sorry, the other player or you cancelled the game.",1);
				ActiveTTT.getTTTHandler(profile).getPlayer2().write("off",2);
				ActiveTTT.getTTTHandler(profile).getPlayer1().write("Sorry, the other player or you cancelled the game.",1);
				ActiveTTT.getTTTHandler(profile).getPlayer1().write("off",2);
				ActiveTTT.unregister(ActiveTTT.getTTTHandler(profile));
				profile.write("Game cancelled.", 1);
				profile.write("OFF", 2);
			}else{
				profile.write("There is no existing game you are in.", 1);
			}
		}
		
	}

}
