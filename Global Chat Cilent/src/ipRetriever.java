import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ipRetriever {
	
	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	private static Pattern pattern;
    private static Matcher matcher;
    private static String ip;
	
	public static boolean setIp(String ip){
		pattern = Pattern.compile(IPADDRESS_PATTERN);
		matcher = pattern.matcher(ip);
		if(matcher.matches()){
			ipRetriever.ip = ip;
			GuiFrame.viewer.append("Ip sucessfully entered.\nConnecting...\n");
			return true;
		}else if(ip.equals("")||ip.equalsIgnoreCase("localhost")){
			ipRetriever.ip = ip;
			GuiFrame.viewer.append("Ip sucessfully entered.\nConnecting...\n");
			return true;
		}else{
			GuiFrame.viewer.append("Ip invalid, pls try again.\n");
			return false;
		}
	}
	public static String getIp(){
		return ip;
	}
}
