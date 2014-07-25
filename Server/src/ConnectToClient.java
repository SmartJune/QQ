import java.net.*;
import java.io.*;

public class ConnectToClient extends Thread{
	
	Socket s;
	
	public ConnectToClient(Socket s){
		this.s = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				try {
					Message mess = (Message) ois.readObject();
			//		System.out.println(mess.getContent());
					if(mess.getMessageType().equals(MessageType.chatMessage)){
						ConnectToClient ctc = SocketThreadManager.getClientSocketThread(mess.getFrom());
						ObjectOutputStream oos = new ObjectOutputStream(ctc.s.getOutputStream());
						oos.writeObject(mess);
					}else if(mess.getMessageType().equals(MessageType.getOnlineList)){
						String list = SocketThreadManager.getOnlineList();
						Message m = new Message();
						m.setMessageType(MessageType.returnList);
						m.setContent(list);
						m.setTo(mess.getFrom());
						ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
						oos.writeObject(m);
					}
					
					
			//here?		
					
					
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
