import java.util.*;

public class ChatFrameManager {
	
	public static HashMap hm = new HashMap<String,ChatFrame>(0);
	
	public static void addChatFrame(String meAndFriend,ChatFrame cf){
		hm.put(meAndFriend, cf);
	}
	public static ChatFrame getChatFrame(String meAndFriend){
		return (ChatFrame)hm.get(meAndFriend);
	}
	
}
