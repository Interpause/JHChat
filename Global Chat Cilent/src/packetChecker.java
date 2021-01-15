import java.io.IOException;


public class packetChecker implements Runnable{
	public static boolean packet = false;
	@Override
	public void run() {
		while(true){
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			if(!packet){
				GuiFrame.send.setEnabled(false);
				GuiFrame.viewer.append("Connection Lost. Pls try again.\n");
				SocketCreator.setActive(false);
				GuiFrame.send.setEnabled(false);
				GuiFrame.btnSetIp.setEnabled(true);
				try {
					SocketCreator.getSocket().close();
					SocketCreator.connection = null;
				} catch (IOException e) {
				}
			}
			packet=false;
		}
	}
	public static void refresh(){
		packet = true;
	}

}
