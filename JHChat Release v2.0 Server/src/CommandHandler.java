
public class CommandHandler {
	static int where = -1;
	static String type, secondmsg, thirdmsg;
	public static void handle(String msg, Profile profile) {
		type = "";
		where = -1;
		secondmsg = "";
		where = msg.indexOf(' ');
		if(where != -1){
			type = msg.substring(0, where);
			secondmsg = msg.substring(where+1, msg.length());
			secondmsg.trim();
		}else{
			type = msg;
		}
		Sender.log(profile.getUsername()+" used "+type);
		if(type.equalsIgnoreCase("/help")){
			profile.write("Current commands available are: /help and /TicTacToe and /online and /pm", 1);
		}else if(type.equalsIgnoreCase("/TicTacToe")){
			if(secondmsg == null||secondmsg.equalsIgnoreCase("")||secondmsg.equalsIgnoreCase(" ")){
				profile.write("Wrong use of command! You have to specify a name you want to play with.",1);
			}else if(ProfileScanner.getProfile(secondmsg)==null){
				profile.write("The player you want to play with does not exist.(or he was erased from time MUAHAHAHAHA)",1);
			}else if(!ProfileScanner.getProfile(secondmsg).getOnline()){
				profile.write("The player you want to play with is offline.",1);
			}else if(ProfileScanner.getProfile(secondmsg).getUsername().equals(profile.getUsername())){
				profile.write("Can't play with yourself dummy.",1);
			}else{
				profile.write("Starting game with "+ProfileScanner.getProfile(secondmsg).getUsername(), 1);
				ProfileScanner.getProfile(secondmsg).write(profile.getUsername()+" wants to play tictactoe with you. Activating Screen... to quit do /quit", 1);
				new TTTHandler(profile,ProfileScanner.getProfile(secondmsg));
			}
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
				ActiveTTT.getTTTHandler(profile).end();
				profile.write("Game cancelled.", 1);
				profile.write("OFF", 2);
			}else{
				profile.write("There is no existing game you are in.", 1);
			}
		}else if(type.equalsIgnoreCase("/logout")){
			profile.write("Goodbye!", 1);
			profile.shutDown();
		}else if(type.equalsIgnoreCase("/pm")){
			where = -1;
			where = secondmsg.indexOf(' ');
			if(where != -1){
				thirdmsg = secondmsg.substring(0, where);
				secondmsg = secondmsg.substring(where+1, secondmsg.length());
				secondmsg.trim();
				System.out.println(secondmsg);
				System.out.println(thirdmsg);
				thirdmsg.trim();
				if(thirdmsg == null||thirdmsg.equalsIgnoreCase("")||thirdmsg.equalsIgnoreCase(" ")){
					profile.write("Wrong usage of pm! Should be like this /pm <user> <msg>",1);
				}else if(ProfileScanner.getProfile(thirdmsg)==null){
					profile.write("The player you are msging does not exist.(or he was erased from time MUAHAHAHAHA)",1);
				}else if(!ProfileScanner.getProfile(thirdmsg).getOnline()){
					profile.write("The player you want to msg is offline.",1);
				}else{
					ProfileScanner.getProfile(thirdmsg).write("Private msg from "+profile.getUsername()+": "+secondmsg, 1);
					profile.write("Private msg to "+ProfileScanner.getProfile(thirdmsg).getUsername()+": "+secondmsg,1);
					Sender.log(profile.getUsername()+ "pm'ed "+ProfileScanner.getProfile(thirdmsg).getUsername()+" saying: "+secondmsg);
					}
			}else{
					profile.write("Wrong usage of pm! Should be like this /pm <user> <msg>",1);
				}
				type = "";
				where = -1;
				secondmsg = "";
				thirdmsg = "";
			
			
		}else{
			profile.write("What did you say, I don't know. Current commands available are: /help and /TicTacToe and /online and /pm and /logout", 1);
		}
		
	}

}
