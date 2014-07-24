import java.util.*;
import java.io.*;

public class OnlineListManager {
	
	public static HashMap hm = new HashMap<String,OnlineList>();

	public static void addOnlineList(String qqId,OnlineList ol){
		hm.put(qqId, ol);
	}
	
	public static OnlineList getOnlineList(String qqId){
		return (OnlineList)hm.get(qqId);
	}
	
}
