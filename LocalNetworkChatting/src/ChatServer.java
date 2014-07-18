import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatServer {
	public static void main(String[] args){
		boolean started = false;
		try {
			ServerSocket ss = new ServerSocket(8887);
			started = true;
			while(started){
				boolean connected = false;
				Socket s = ss.accept();
				System.out.println("client connected success");
				connected = true;
				DataInputStream dataIn = new DataInputStream(s.getInputStream());
				while(connected){
					String string = dataIn.readUTF();
					System.out.println(string);
				}
				dataIn.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
