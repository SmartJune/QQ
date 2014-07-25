import java.net.*;
import java.io.*;

public class QqServer{
	ServerSocket ss;
	Socket s;
	Message m = new Message();
	ObjectInputStream ois;
	ObjectOutputStream oos;
	User u;
	boolean started = false;
	
	public QqServer() {
		
		try {
			ss = new ServerSocket(9999);
			started = true;
			System.out.println("server start----");
			
			while(started){
				s = ss.accept(); //waiting to connect
				oos = new ObjectOutputStream(s.getOutputStream());
				ois = new ObjectInputStream(s.getInputStream());
				try {
					u = (User)ois.readObject();
					
			//		System.out.println("ID:"+u.getUserId()+"   "+"Password:"+u.getPassword());
					
					if(u.getUserId().equals("1")&& u.getPassword().equals("a")){
						m.setMessageType("1");
				//		System.out.println("没错啊就是1");
						oos.writeObject(m);
						
						ConnectToClient ctc = new ConnectToClient(s);
						SocketThreadManager.addClientSocketThread(u.getUserId(),ctc);;
						ctc.start();
						ctc.IAmComing(u.getUserId());
						
					}else if(u.getUserId().equals("2")&& u.getPassword().equals("b")){
						m.setMessageType("1");
				//		System.out.println("没错啊就是1");
						oos.writeObject(m);
						
						ConnectToClient ctc = new ConnectToClient(s);
						SocketThreadManager.addClientSocketThread(u.getUserId(),ctc);;
						ctc.start();
						ctc.IAmComing(u.getUserId());
						
					}else if(u.getUserId().equals("3")&& u.getPassword().equals("c")){
						m.setMessageType("1");
				//		System.out.println("没错啊就是1");
						oos.writeObject(m);
						
						ConnectToClient ctc = new ConnectToClient(s);
						SocketThreadManager.addClientSocketThread(u.getUserId(),ctc);;
						ctc.start();
						ctc.IAmComing(u.getUserId());
						
					}else{
						m.setMessageType("2");
						oos.writeObject(m);
						s.close();
					}		
					
			/*		if(m.getMessageType().equals("1")){
						ConnectToClient ctc = new ConnectToClient(s);
						SocketThreadManager.addClientSocketThread(u.getUserId(),ctc);;
						ctc.start();
						*/
		//				Thread t = new Thread(ctc);
		//				t.start();
		//			}
					
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

	public void closeServer(){
		started = false;
//	s.close();
//	ss.close();
		System.out.println("server closed");
	}

/*	@Override
	public void run() {
		// TODO Auto-generated method stub
		startServer();
	}
	*/
}
