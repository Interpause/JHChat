class PacketReceiver implements Runnable{
	
	boolean update = false;
	
	@Override
	public void run() {
		while(true){
			if(SocketCreator.isUpdated){
				update = true;
				SocketCreator.isUpdated = false;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			}else if(!update){
				ShutDown.shutDown();
				break;
			}
			
			update = false;
		}
	}

	
	
}