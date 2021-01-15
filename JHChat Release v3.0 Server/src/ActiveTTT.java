import java.util.LinkedList;


public class ActiveTTT {
	private static LinkedList<TTTHandler> games = new LinkedList<TTTHandler>();
	public static void unregister(TTTHandler tttHandler) {
		games.remove(tttHandler);
		
	}
	public static void register(TTTHandler tttHandler) {
		games.add(tttHandler);
		
	}
	public static void play(Profile player, int button){
		try{
			for(TTTHandler check:games){
				if(check.getPlayer1().getUsername().equals(player.getUsername())){
					if(check.getPlayer2()!=null){
						check.Handle(button, false);
					}else{
						check.Handle(button);
					}
					
				}else if(check.getPlayer2().getUsername().equals(player.getUsername())){
					check.Handle(button, true);
				}
			}
		}catch(NullPointerException e){
			return;
		}
	}
	public static TTTHandler getTTTHandler(Profile player){
		try{
			for(TTTHandler check:games){
				if(check.getPlayer1().getUsername().equals(player.getUsername())){
					return check;
				}else if(check.getPlayer2().getUsername().equals(player.getUsername())){
					return check;
				}
			}
		}catch(NullPointerException e){
			return null;
		}
		return null;
	}

}
