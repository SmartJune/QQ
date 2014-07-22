import java.net.*;
import java.io.*;

public class QqServer {

	Message m = new Message();
	ObjectInputStream ois;
	ObjectOutputStream oos;
	public QqServer() {
		
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("server start----");
			
			while(true){
				Socket s = ss.accept(); //waiting to connect
				oos = new ObjectOutputStream(s.getOutputStream());
				ois = new ObjectInputStream(s.getInputStream());
				try {
					User u = (User)ois.readObject();
					
					System.out.println("ID:"+u.getUserId()+"   "+"Password:"+u.getPassword());
					
					if(u.getUserId().equals("a")&& u.getPassword().equals("b")){
						m.setMessageType("1");
						System.out.println("没错啊就是1");
						oos.writeObject(m);
					}else{
						m.setMessageType("2");
						oos.writeObject(m);
						s.close();
					}		
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		
	}
	
}
