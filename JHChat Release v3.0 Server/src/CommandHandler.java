
public class CommandHandler {
	int where = -1;
	String type, secondmsg, thirdmsg;
	CommandHandler(){
		
	}
	public void handle(String msg, Profile profile) {
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
		if(type==null){
			profile.write("What did you say, I don't know. Current commands available are: /help and /info and /TicTacToe and /score and /online and /pm and /logout and /delete", 1);
		}
		Sender.log(profile.getUsername()+" used "+type);
		if(type.equalsIgnoreCase("/help")){
			profile.write("Current commands available are: /help and /info and /TicTacToe and /score and /online and /pm and /logout and /delete", 1);
		}else if(type.equalsIgnoreCase("/TicTacToe")){
			if(ActiveTTT.getTTTHandler(profile)!=null){
				profile.write("You are already in a game!", 1);
			}else if(secondmsg == null||secondmsg.equalsIgnoreCase("")||secondmsg.equalsIgnoreCase(" ")){
				profile.write("AI Game will start soon...(he is a busy man he goes one at a time)", 1);
				new TTTHandler(profile);
			}else if(ProfileScanner.getProfile(secondmsg)==null){
				profile.write("The player you want to play with does not exist.(or he was erased from time MUAHAHAHAHA)",1);
			}else if(!ProfileScanner.getProfile(secondmsg).getOnline()){
				profile.write("The player you want to play with is offline.",1);
			}else if(ProfileScanner.getProfile(secondmsg).getUsername().equals(profile.getUsername())){
				profile.write("Can't play with yourself dummy.",1);
			}else if(ActiveTTT.getTTTHandler(ProfileScanner.getProfile(secondmsg))!=null){
				profile.write("He is busy at the moment sorry.",1);
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
		}else if(type.equalsIgnoreCase("/info")){
			profile.write("Programmed by John-Henry Lim. V3", 1);
			profile.write("/help displays available commands.", 1);
			profile.write("/info displays info about how to use the commands.", 1);
			profile.write("/tictactoe starts a tictactoe game with another player. Usage: /tictactoe <name of opponent(case sensitive)>. If you dont specify opponent, you will battle an AI. You win count will be stored. If you lose you lose one win count(jk).", 1);
			profile.write("/score <username> shows the score of that user at tictactoe.", 1);
			profile.write("/online displays all users online.", 1);
			profile.write("/pm privately messages another user. Usage: /pm <person to message(case sensitive)> <message>", 1);
			profile.write("/logout disconnects you from the server.",1);
			profile.write("/delete deletes you from the server.",1);
			profile.write("Do not spam, bot or insult as you can get banned!(actually as of now I dont really have the ability to ban)", 1);
		}else if(type.equalsIgnoreCase("/quit")){
			if(ActiveTTT.getTTTHandler(profile)!=null){

				ActiveTTT.getTTTHandler(profile).end(1);
				profile.write("Game cancelled.", 1);
				profile.write("OFF", 2);
			}else{
				profile.write("There is no existing game you are in.", 1);
			}
		}else if(type.equalsIgnoreCase("/logout")){
			profile.write("Goodbye!", 1);
			profile.shutDown();
		}else if(type.equalsIgnoreCase("/delete")){
			profile.write("Goodbye!", 1);
			profile.shutDown();
			ProfileScanner.removeProfile(profile.getUsername());
		}else if(type.equalsIgnoreCase("/score")){
			if(secondmsg == null||secondmsg.equalsIgnoreCase("")||secondmsg.equalsIgnoreCase(" ")){
				profile.write("Specify a username for /score <username>!", 1);
			}else if(ProfileScanner.getProfile(secondmsg)==null){
				profile.write("The player you want to check with does not exist.(or he was erased from time MUAHAHAHAHA)",1);
			}else{
				profile.write(secondmsg+" has won "+ProfileScanner.getProfile(secondmsg).getTicTacToeWins()+ " times.",1);
			}
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
			profile.write("What did you say, I don't know. Current commands available are: /help and /info and /TicTacToe and /score and /online and /pm and /logout and /delete", 1);
		}
		
	}

}
