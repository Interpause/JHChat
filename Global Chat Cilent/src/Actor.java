import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actor implements ActionListener{
	public static String tosend;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==GuiFrame.btnSetIp){
			Thread t = new Thread(new IPSetter());
			t.start();
			GuiFrame.btnSetIp.setEnabled(false);
		}
		else if(e.getSource()==GuiFrame.send){
			tosend=GuiFrame.sender.getText();
			GuiFrame.sender.setText("");
			int where = tosend.indexOf('/');
			if(where==0){
				SocketSender.setSendValue(1);
				SocketSender.send(tosend);
				SocketSender.setSendValue(0);
			}else{
			SocketSender.send(tosend);
			}
		}
		
	}

}
