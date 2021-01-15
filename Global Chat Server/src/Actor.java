import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Actor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==GUI.setmotd){
			Function.setMotd(GUI.motd.getText());
			GUI.viewer.append("MOTD set to "+Function.getMotd()+"\n");
		}
		
	}

}
