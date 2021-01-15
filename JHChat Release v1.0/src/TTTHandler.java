
public class TTTHandler {
	private static char letter;
	private static int where;
	public static void process(String process){
		if(process.equalsIgnoreCase("OFF")){
			Main.setTTTMode(false);
		}else if(process.equalsIgnoreCase("ON")){
			Main.setTTTMode(true);
		}else{
			for(int i = 1; i != 9; i++){
				letter = ' ';
				where = -1;
				where = process.indexOf(i);
				if(where != -1){
					letter = process.substring(0, where).toCharArray()[0];
					Main.setTTTButton(i, letter);
					process = process.substring(where+1,process.length());
				}
		}
		}
	}

	public static void Pressed(int Button){
		Communicator.write(""+Button, 2);
	}
	
}
