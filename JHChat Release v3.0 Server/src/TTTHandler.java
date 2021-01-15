
public class TTTHandler {
	/**
	 * false is p1 true is p2
	 */
	private boolean turn = false, ended = false, isAI = false;
	private Profile player1, player2;
	private TTTAI handler;
	/**
	 * false is p1 true is p2
	 */
	private char[] value = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
	
	public TTTHandler(Profile player1, Profile player2){
		isAI = false;
		this.player1 = player1;
		this.player2 = player2;
		Sender.log(player1.getUsername()+" has started TicTacToe game with "+player2.getUsername());
		ActiveTTT.register(this);
		player1.write("ON",2);
	}
	
	public TTTHandler(Profile player1){
		isAI = true;
		this.player1 = player1;
		this.player2 = null;
		handler = new TTTAI();
		Sender.log(player1.getUsername()+" has started TicTacToe game with AI");
		ActiveTTT.register(this);
		player1.write("ON",2);
	}
	
	public void Handle(int button, boolean player){
		if(player == turn&&!isAI){
			if(value[button-1]==' '){
				if(!turn){
					
					value[button-1]='x';
					player1.write("x,"+(button),2);
					player2.write("x,"+(button),2);
					if(value[0]=='x'&&value[1]=='x'&&value[2]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[3]=='x'&&value[4]=='x'&&value[5]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[6]=='x'&&value[7]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='x'&&value[3]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[1]=='x'&&value[4]=='x'&&value[7]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='x'&&value[5]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='o'&&value[1]=='o'&&value[2]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[3]=='o'&&value[4]=='o'&&value[5]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[6]=='o'&&value[7]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='o'&&value[3]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[1]=='o'&&value[4]=='o'&&value[7]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='o'&&value[5]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='x'&&value[4]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='x'&&value[4]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='o'&&value[4]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='o'&&value[4]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if((value[0]=='o'||value[0]=='x')&&(value[1]=='o'||value[1]=='x')&&(value[2]=='o'||value[2]=='x')&&(value[3]=='o'||value[3]=='x')&&(value[4]=='o'||value[4]=='x')&&(value[5]=='o'||value[5]=='x')&&(value[6]=='o'||value[6]=='x')&&(value[7]=='o'||value[7]=='x')&&(value[8]=='o'||value[8]=='x')){
						player2.write("No one won :|", 1);
						player1.write("No one won :|", 1);
						end(0);
					}
					if(!ended){
						player1.write("OFF", 2);
						player2.write("ON", 2);
						player1.write("It is "+player2.getUsername()+"'s turn!", 1);
						player2.write("It is your turn!", 1);
					}
				}else{
					value[button-1]='o';
					player1.write("o,"+(button),2);
					player2.write("o,"+(button),2);
					if(value[0]=='x'&&value[1]=='x'&&value[2]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[3]=='x'&&value[4]=='x'&&value[5]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[6]=='x'&&value[7]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='x'&&value[3]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[1]=='x'&&value[4]=='x'&&value[7]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='x'&&value[5]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='o'&&value[1]=='o'&&value[2]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[3]=='o'&&value[4]=='o'&&value[5]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[6]=='o'&&value[7]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='o'&&value[3]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[1]=='o'&&value[4]=='o'&&value[7]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='o'&&value[5]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='x'&&value[4]=='x'&&value[8]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='x'&&value[4]=='x'&&value[6]=='x'){
						player1.write("You Won!", 1);
						player1.winTicTacToe();
						player2.write("you lose :(", 1);
						end(0);
					}else if(value[0]=='o'&&value[4]=='o'&&value[8]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if(value[2]=='o'&&value[4]=='o'&&value[6]=='o'){
						player2.write("You Won!", 1);
						player2.winTicTacToe();
						player1.write("you lose :(", 1);
						end(0);
					}else if((value[0]=='o'||value[0]=='x')&&(value[1]=='o'||value[1]=='x')&&(value[2]=='o'||value[2]=='x')&&(value[3]=='o'||value[3]=='x')&&(value[4]=='o'||value[4]=='x')&&(value[5]=='o'||value[5]=='x')&&(value[6]=='o'||value[6]=='x')&&(value[7]=='o'||value[7]=='x')&&(value[8]=='o'||value[8]=='x')){
						player2.write("No one won :|", 1);
						player1.write("No one won :|", 1);
						end(0);
					}
					if(!ended){
						player1.write("ON", 2);
						player2.write("OFF", 2);
						player1.write("It is your turn!", 1);
						player2.write("It is "+player1.getUsername()+"'s turn!", 1);
						
					}
				}
				turn = !turn;
			}
		}
	}
	public void end(int a){
		player1.write("RESET", 2);
		if(player2!=null){
			player2.write("RESET", 2);
			ended=true;	
				if(a==1){
					player2.write("Sorry, the other player or you cancelled the game.",1);
					player2.write("off",2);
					player1.write("Sorry, the other player or you cancelled the game.",1);
					player1.write("off",2);
				}
			Sender.log(player1.getUsername()+" and "+player2.getUsername()+"'s game has ended.");
		}else{
			ended=true;
			if(a==1){
				player1.write("Sorry, the other player or you cancelled the game.",1);
				player1.write("off",2);
			}
			Sender.log(player1.getUsername()+"'s tictactoe Ended.");
		}
		
		ActiveTTT.unregister(this);
	}
	
	public Profile getPlayer1(){
		return player1;
	}
	public Profile getPlayer2(){
		return player2;
	}

	public void Handle(int button) {
		if(value[button-1]==' '&&isAI){
			if(!turn){
				
				value[button-1]='x';
				player1.write("x,"+(button),2);
				handler.write("GAME@x,"+(button),2);
				if(value[0]=='x'&&value[1]=='x'&&value[2]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[3]=='x'&&value[4]=='x'&&value[5]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[6]=='x'&&value[7]=='x'&&value[8]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[0]=='x'&&value[3]=='x'&&value[6]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[1]=='x'&&value[4]=='x'&&value[7]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[2]=='x'&&value[5]=='x'&&value[8]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[0]=='o'&&value[1]=='o'&&value[2]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[3]=='o'&&value[4]=='o'&&value[5]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[6]=='o'&&value[7]=='o'&&value[8]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[0]=='o'&&value[3]=='o'&&value[6]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[1]=='o'&&value[4]=='o'&&value[7]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[2]=='o'&&value[5]=='o'&&value[8]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[0]=='x'&&value[4]=='x'&&value[8]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[2]=='x'&&value[4]=='x'&&value[6]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[0]=='o'&&value[4]=='o'&&value[8]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[2]=='o'&&value[4]=='o'&&value[6]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if((value[0]=='o'||value[0]=='x')&&(value[1]=='o'||value[1]=='x')&&(value[2]=='o'||value[2]=='x')&&(value[3]=='o'||value[3]=='x')&&(value[4]=='o'||value[4]=='x')&&(value[5]=='o'||value[5]=='x')&&(value[6]=='o'||value[6]=='x')&&(value[7]=='o'||value[7]=='x')&&(value[8]=='o'||value[8]=='x')){
					player1.write("No one won :|", 1);
					end(0);
				}
				if(!ended){
					player1.write("OFF", 2);
					handler.write("GAME@ON", 2);
					player1.write("It is Computer's turn!", 1);
					turn = !turn;
					Handle();
				
				}
			}
		}
	}
			
		public void Handle(){
			if(isAI){
				if(turn){
					handler.write("GAME@ON", 2);
				value[handler.getMove()-1]='o';
				player1.write("o,"+(handler.getMove()),2);
				handler.write("GAME@o,"+(handler.getMove()),2);
				if(value[0]=='x'&&value[1]=='x'&&value[2]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[3]=='x'&&value[4]=='x'&&value[5]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[6]=='x'&&value[7]=='x'&&value[8]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[0]=='x'&&value[3]=='x'&&value[6]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[1]=='x'&&value[4]=='x'&&value[7]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[2]=='x'&&value[5]=='x'&&value[8]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[0]=='o'&&value[1]=='o'&&value[2]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[3]=='o'&&value[4]=='o'&&value[5]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[6]=='o'&&value[7]=='o'&&value[8]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[0]=='o'&&value[3]=='o'&&value[6]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[1]=='o'&&value[4]=='o'&&value[7]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[2]=='o'&&value[5]=='o'&&value[8]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[0]=='x'&&value[4]=='x'&&value[8]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[2]=='x'&&value[4]=='x'&&value[6]=='x'){
					player1.write("You Won!", 1);
					player1.winTicTacToe();
					end(0);
				}else if(value[0]=='o'&&value[4]=='o'&&value[8]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if(value[2]=='o'&&value[4]=='o'&&value[6]=='o'){
					player1.write("you lose :(", 1);
					end(0);
				}else if((value[0]=='o'||value[0]=='x')&&(value[1]=='o'||value[1]=='x')&&(value[2]=='o'||value[2]=='x')&&(value[3]=='o'||value[3]=='x')&&(value[4]=='o'||value[4]=='x')&&(value[5]=='o'||value[5]=='x')&&(value[6]=='o'||value[6]=='x')&&(value[7]=='o'||value[7]=='x')&&(value[8]=='o'||value[8]=='x')){
					player1.write("No one won :|", 1);
					end(0);
				}
				if(!ended){
					player1.write("ON", 2);
					handler.write("OFF", 2);
					player1.write("It is your turn!", 1);
					turn = !turn;
				}
			
				}
		}
		}
}
		
	

