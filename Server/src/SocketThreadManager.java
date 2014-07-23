import java.util.*;

public class SocketThreadManager {
	
	public static HashMap hm = new HashMap<String,ConnectToClient>();
	
	public static void addClientSocketThread(String userId,ConnectToClient ctc){
		hm.put(userId,ctc);
	}
	public static ConnectToClient getClientSocketThread(String userId){
		return (ConnectToClient)hm.get(userId);
	}
}
