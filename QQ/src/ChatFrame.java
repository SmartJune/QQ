import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class ChatFrame extends JFrame implements ActionListener,Runnable{
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String friend;
	String owner;
	public ChatFrame(String friend,String owner){
		jta = new JTextArea();
		jta.setEditable(false);
		jtf = new JTextField(30);
		jb = new JButton("send");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.friend = friend;
		this.owner = owner;
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle(owner +" is now chatting with "+friend);
		this.setSize(500,400);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb){
			Message mess = new Message();
			mess.setContent(jtf.getText().trim());
			mess.setFrom(owner);
			mess.setTo(friend);
			try {
				ObjectOutputStream oos = new ObjectOutputStream(ConnectToServer.s.getOutputStream());
				oos.writeObject(mess);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(ConnectToServer.s.getInputStream());
				try {
					Message mess = (Message)ois.readObject();
					String info = mess.getContent();
					this.jta.append(info);
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
