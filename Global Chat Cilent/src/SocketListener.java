import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;


public class SocketListener implements Runnable{
	BufferedReader in;
	String type="";
	URL file;
	Clip push;
	@Override
	public void run() {
		
		try {
			in = new BufferedReader(new InputStreamReader(SocketCreator.getSocket().getInputStream()));
		} catch (IOException e) {
		}
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
			String recieved="";
			try {
				recieved = in.readLine();
				packetChecker.refresh();
				int where = recieved.indexOf('@');
				if(where!=-1){
				type = recieved.substring(0, where+1);
				recieved = recieved.substring(where+1,recieved.length());
				}
				System.out.println(type + "ddd" + recieved);
			} catch (IOException e) {
			}
			if(type.equalsIgnoreCase("GLOBALTEXT@")){
				AudioInputStream audioPush = null;
				try {
			        push = AudioSystem.getClip();

			        URL urlPush = getClass().getResource(
			                    "beep.wav");

			        audioPush = AudioSystem.getAudioInputStream(urlPush);

			        push.open(audioPush);

			    } catch (IOException e) {
			        e.printStackTrace();
			    } catch (LineUnavailableException e) {
			        e.printStackTrace();
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
				GuiFrame.viewer.append(recieved+"\n");
				push.start();
				recieved="";
				type="";
				GuiFrame.viewer.setCaretPosition(GuiFrame.viewer.getDocument().getLength());
			}else if(type.equalsIgnoreCase("SYSTEM@")){
			}
			type="";
		}
	}

}
