
public class PacketSender implements Runnable {

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
				Communicator.refresh();
			} catch (InterruptedException e) {}
			Communicator.refresh();
		}

	}

}
