import java.net.*;
import java.io.*;

public class ConnectToClient implements Runnable{
	
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
					
					ConnectToClient ctc = SocketThreadManager.getClientSocketThread(mess.getTo());
					ObjectOutputStream oos = new ObjectOutputStream(ctc.s.getOutputStream());
					oos.writeObject(mess);
					
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
