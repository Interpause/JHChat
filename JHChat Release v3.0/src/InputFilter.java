
public class InputFilter {
	
	private static int where;
	private static String received;
	private static String type;
	
	public static void filter(String input) {

		received = "";
		type = "";
		where = -1;
		received = input.trim();
		where = received.indexOf('@');

		if(where != -1){
			type = received.substring(0, where+1);

			received = received.substring(where+1,received.length());
			System.out.println("Recieved type: "+ type + " Message: " + received);
			type = type.trim();
			received = received.trim();
		if(type.equalsIgnoreCase("MSG@")){
			Main.write(received);
		}else if(type.equalsIgnoreCase("REFRESH@")){
		}else if(type.equalsIgnoreCase("GAME@")){
			TTTHandler.process(received);
		}else if(type.equalsIgnoreCase("COMMAND@")){
			if(received.equalsIgnoreCase("DISCONNECT")){
				ShutDown.shutDown();
			}
		}
		}
		
	}

}
