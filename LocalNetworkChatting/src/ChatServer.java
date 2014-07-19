import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	
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
				Thread d = new Thread(c);
				d.start();
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
		boolean connected = false;
		
		public Client(Socket s){
			this.s = s;
			try {
				dataIn = new DataInputStream(s.getInputStream());
				connected = true;
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
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try {
					dataIn.close();
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	}
		}
}
