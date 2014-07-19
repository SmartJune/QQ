
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	List<Client> clients = new ArrayList<Client>();
	
	public static void main(String[] args){
		
	//	DataInputStream dataIn = null;
		new ChatServer().start();
	}
	
	public void start(){
		try {
			ss = new ServerSocket(8887);
			started = true;
		}catch(IOException e){
			e.printStackTrace();
		}
		try {
			while(started){
			//	boolean connected = false;
				Socket s = ss.accept();
				Client c = new Client(s);
				System.out.println("client connected success");
		//		Thread d = new Thread(c);
		//		d.start();
				new Thread(c).start();
				clients.add(c);
				}
			//	dataIn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		} finally{
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class Client implements Runnable{
		private Socket s;
		DataInputStream dataIn = null;
		DataOutputStream dataOut = null;
		boolean connected = false;
		
		public Client(Socket s){
			this.s = s;
			try {
				dataIn = new DataInputStream(s.getInputStream());
				dataOut = new DataOutputStream(s.getOutputStream());
				connected = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void sendMessage(String message){
			try {
				dataOut.writeUTF(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
			while(connected){
				String string = dataIn.readUTF();
				System.out.println(string);
				for(int i = 0;	i<clients.size();i++){
					Client c = clients.get(i);
					c.sendMessage(string);
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					dataIn.close();
					dataOut.close();
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	}
		}
}
