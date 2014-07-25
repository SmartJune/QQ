import java.util.*;

public class SocketThreadManager {
	
	public static HashMap hm = new HashMap<String,ConnectToClient>();
	
	public static void addClientSocketThread(String userId,ConnectToClient ctc){
		hm.put(userId,ctc);
	}
	public static ConnectToClient getClientSocketThread(String userId){
		return (ConnectToClient)hm.get(userId);
	}
	public static String getOnlineList(){
		
//get online list message from hashmap
		Iterator it = hm.keySet().iterator();
		String list = "";
		while(it.hasNext()){
		//	Object o = it.next();
		//	list = list + ((User)o).getUserId() + " ";
			list = list + it.next().toString() + " ";
			System.out.println("Online list ： " + list);
		}
		return "a";
	}
}
