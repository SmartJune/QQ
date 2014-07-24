import java.util.*;

public class ClientThreadManager {

	public static HashMap hm = new HashMap<String,ClientThread>();
	
	public static void addClientThread(String userId,ClientThread ct){
		hm.put(userId,ct);
	}
	public static ClientThread getClientThread(String userId){
		return (ClientThread)hm.get(userId);
	}
	
}
