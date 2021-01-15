
public class TTTHandler {

	public static void process(String process){
		if(process.equalsIgnoreCase("OFF")){
			Main.setTTTMode(false);
		}else if(process.equalsIgnoreCase("ON")){
			Main.setTTTMode(true);
		}else if(process.equalsIgnoreCase("RESET")){
			Main.TTTClear();
			Main.setTTTMode(false);
		}else{
			int where = process.indexOf(',');
			if(where != -1){
				String type = process.substring(0, where+1);
				process = process.substring(where+1,process.length());
				process = process.trim();
				type = type.trim();
				if(type.equals("x,")){
					Main.setTTTButton(Integer.parseInt(process), 'x');
				}else{
					Main.setTTTButton(Integer.parseInt(process), 'o');
				}
			}
		}
	}

	public static void Pressed(int Button){
		Communicator.write(""+Button, 2);
	}
	
}
