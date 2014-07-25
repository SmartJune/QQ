import java.io.*;
import java.net.*;

public class ClientThread extends Thread{
	
	//class of getting message package
	
	private Socket s;
	
	public ClientThread(Socket s){
		this.s = s;
	}
	
	public Socket getSocket(){
		
		return s;
	}
	
	public void run(){
		while(true){
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(s.getInputStream());
				try {
					Message mess = (Message)ois.readObject();
					System.out.println(mess.getFrom()+"to"+mess.getTo()+"说："+mess.getContent());
					if(mess.getMessageType().equals(MessageType.chatMessage)){
						ChatFrame cf = ChatFrameManager.getChatFrame(mess.getFrom()+" "+mess.getTo());
						cf.showMessage(mess);
					}else if(mess.getMessageType().equals(MessageType.returnList)){
						//try to return a string with many people online
						System.out.println(mess.getTo()+"get his friend list");
						System.out.println("内容是："+mess.getContent());
						String list = mess.getContent();
						String guys[] = list.split(" ");
						
						OnlineList ol = OnlineListManager.getOnlineList(mess.getTo());
////////////////////change the list at here
						ol.updateList(mess);
						
					}
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
