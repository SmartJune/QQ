import java.util.*;
import java.io.*;
import java.net.*;

public class ConnectToServer {
	public Socket s;
	public boolean sendLoginInfoToServer(Object o){
		
		boolean b = false;
		try {
			s = new Socket("192.168.43.27",9999);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			try {
				Message ms = (Message)ois.readObject();
				System.out.println(ms.getMessageType());
				if(ms.getMessageType().equals("1")){
					b = true;
					//if login message true ,start a thread of client to server 
					//if succeed , we will not limited by only one socket provided
					ClientThread ct = new ClientThread(s);
					ct.start();
					ClientThreadManager.addClientThread(ms.getFrom(),ct);  //ms or o?
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public void sendMessageToServer(Object o){
		try {
			Socket s = new Socket("192.168.1.100",9999);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
