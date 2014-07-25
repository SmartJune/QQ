import java.util.*;
import java.io.*;
import java.net.*;

public class ConnectToServer {
	public Socket s;
	public boolean sendLoginInfoToServer(Object o){
		System.out.println("进入检测函数");
		boolean b = false;
		try {
			s = new Socket("192.168.1.104",9999);
			System.out.println("连接至服务器");
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
		//			User u = (User) o;
					ClientThreadManager.addClientThread(((User)o).getUserId(),ct);  //ms or o?
				}
				else{
					s.close();
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
