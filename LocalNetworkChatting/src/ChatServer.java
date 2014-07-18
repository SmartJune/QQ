import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {
	public static void main(String[] args){
		boolean started = false;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dataIn = null;
		
		try {
			ss = new ServerSocket(8887);
		}catch(IOException e){
			e.printStackTrace();
		}
		try {
			started = true;
			while(started){
				boolean connected = false;
				s = ss.accept();
				System.out.println("client connected success");
				connected = true;
				dataIn = new DataInputStream(s.getInputStream());
				while(connected){
					String string = dataIn.readUTF();
					System.out.println(string);
				}
				dataIn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				dataIn.close();
				s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
