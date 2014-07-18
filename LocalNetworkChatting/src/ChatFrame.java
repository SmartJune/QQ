import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;


public class ChatFrame extends JFrame{
	DataOutputStream dataOut = null;
	Socket socket = null;
	TextField textField = new TextField();
	TextArea textArea = new TextArea();
	
	public ChatFrame(){
		super("聊天");
		setLocation(400,300);
		this.setSize(300,300);
		add(textField,BorderLayout.SOUTH);
		add(textArea,BorderLayout.NORTH);
		pack();
		addWindowListener(new WindowAdapter(){
			public void WindowClosing(WindowEvent arg0){
				disconnected();
				System.exit(0);
			}
		});
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField.addActionListener(new TextFieldListener());
		setVisible(true);
		connectToServer();
	}
	public void connectToServer(){
		try {
			socket = new Socket("192.168.1.103",8887);
			dataOut = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("connect to server successfully.");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void disconnected(){
		try {
			dataOut.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private class TextFieldListener implements ActionListener{
	@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			String string = textField.getText().trim();
			textArea.setText(string);
			textField.setText("");
			
			try {
				dataOut.writeUTF(string);
				dataOut.flush();
		//		dataOut.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
}
