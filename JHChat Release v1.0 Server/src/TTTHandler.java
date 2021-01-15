
public class TTTHandler {
	/**
	 * false is p1 true is p2
	 */
	private boolean turn = false;
	private Profile player1, player2;
	/**
	 * false is p1 true is p2
	 */
	private char[] value = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
	
	public TTTHandler(Profile player1, Profile player2){
		ActiveTTT.register(this);
		player1.write("ON",2);
		player2.write("ON",2);
	}
	
	public void Handle(int button, boolean player){
		if(player == turn){
			if(value[button-1]==' '){
				if(!turn){
					
					value[button-1]='x';
					if(value[0]=='x'&&value[1]=='x'&&value[2]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[3]=='x'&&value[4]=='x'&&value[5]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[6]=='x'&&value[7]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[0]=='x'&&value[3]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[1]=='x'&&value[4]=='x'&&value[7]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[2]=='x'&&value[5]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[0]=='o'&&value[1]=='o'&&value[2]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[3]=='o'&&value[4]=='o'&&value[5]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[6]=='o'&&value[7]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[0]=='o'&&value[3]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[1]=='o'&&value[4]=='o'&&value[7]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[2]=='o'&&value[5]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[0]=='x'&&value[4]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[2]=='x'&&value[4]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[0]=='o'&&value[4]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[2]=='o'&&value[4]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if((value[0]=='o'||value[0]=='x')&&(value[1]=='o'||value[1]=='x')&&(value[2]=='o'||value[2]=='x')&&(value[3]=='o'||value[3]=='x')&&(value[4]=='o'||value[4]=='x')&&(value[5]=='o'||value[5]=='x')&&(value[6]=='o'||value[6]=='x')&&(value[7]=='o'||value[7]=='x')&&(value[8]=='o'||value[8]=='x')){
						player2.write("No one won :|", 1);
						player1.write("No one won :|", 1);
						end();
					}
					player1.write("off", 3);
					player2.write("on", 3);
					player1.write("It is "+player2.getUsername()+" turn!", 1);
					player2.write("It is your turn!", 1);
				}else{
					value[button-1]='o';
					if(value[0]=='x'&&value[1]=='x'&&value[2]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[3]=='x'&&value[4]=='x'&&value[5]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[6]=='x'&&value[7]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[0]=='x'&&value[3]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[1]=='x'&&value[4]=='x'&&value[7]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[2]=='x'&&value[5]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[0]=='o'&&value[1]=='o'&&value[2]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[3]=='o'&&value[4]=='o'&&value[5]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[6]=='o'&&value[7]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[0]=='o'&&value[3]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[1]=='o'&&value[4]=='o'&&value[7]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[2]=='o'&&value[5]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[0]=='x'&&value[4]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[2]=='x'&&value[4]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player2.write("you lose :(", 1);
						end();
					}else if(value[0]=='o'&&value[4]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if(value[2]=='o'&&value[4]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player1.write("you lose :(", 1);
						end();
					}else if((value[0]=='o'||value[0]=='x')&&(value[1]=='o'||value[1]=='x')&&(value[2]=='o'||value[2]=='x')&&(value[3]=='o'||value[3]=='x')&&(value[4]=='o'||value[4]=='x')&&(value[5]=='o'||value[5]=='x')&&(value[6]=='o'||value[6]=='x')&&(value[7]=='o'||value[7]=='x')&&(value[8]=='o'||value[8]=='x')){
						player2.write("No one won :|", 1);
						player1.write("No one won :|", 1);
						end();
					}
					player1.write("on", 3);
					player2.write("off", 3);
					player1.write("It is your turn!", 1);
					player2.write("It is "+player1.getUsername()+" turn!", 1);
				}
				turn = !turn;
			}
		}
	}
	public void end(){
		ActiveTTT.unregister(this);
	}
	
	public Profile getPlayer1(){
		return player1;
	}
	public Profile getPlayer2(){
		return player2;
	}
}
