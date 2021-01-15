
public class PacketSender implements Runnable{

	@Override
	public void run() {
		GUI.viewer.append("HeartPulsar V1 active.\n");
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
			Sender.send("refresh");
		}
		
	}

}
