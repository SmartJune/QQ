import java.io.*;
import java.net.*;

public class ClientThread extends Thread{
	
	private Socket s;
	
	public ClientThread(Socket s){
		this.s = s;
	}
	
	public Socket getSocket(){
		
		return s;
	}
	
	public void run(){
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(s.getInputStream());
			try {
				Message mess = (Message)ois.readObject();
				System.out.println(mess.getFrom()+"to"+mess.getTo()+"说："+mess.getContent());
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
