import java.util.*;

public class ClientThreadManager {

	public static HashMap hm = new HashMap<String,ClientThread>();
	
	public static void addClientThread(String string,ClientThread ct){
		hm.put(string,ct);
	}
	public static ClientThread getClientThread(String userId){
		return (ClientThread)hm.get(userId);
	}
	
}
