
public class IPSetter implements Runnable{

	@Override
	public void run() {
		Actor.tosend=GuiFrame.sender.getText();
		GuiFrame.sender.setText("");
		GuiFrame.accept = ipRetriever.setIp(Actor.tosend);
		if(GuiFrame.accept){
			GuiFrame.send.setEnabled(true);
			SocketCreator.getSocket();
		}else{
			GuiFrame.btnSetIp.setEnabled(true);
		}
		Actor.tosend=null;
		
	}

}
