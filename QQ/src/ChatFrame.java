import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class ChatFrame extends JFrame implements ActionListener{
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String friend;
	String owner;
	Message ownMess;
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
	public void showMessage(Message mess){
		String info = mess.getFrom()+"对"+mess.getTo()+"说："+mess.getContent()+"\n";
		this.jta.append(info);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb){
			ownMess = new Message();
			ownMess.setContent(jtf.getText().trim());
			// here ,change identify to send message properly,not the right way
			ownMess.setTo(owner);
			ownMess.setFrom(friend);			
			//no problem
			try {
				ObjectOutputStream oos = new ObjectOutputStream(ClientThreadManager.
						getClientThread(owner).getSocket().getOutputStream());
				oos.writeObject(ownMess);
				
			//	String infoma = ownMess.getFrom()+":"+ownMess.getContent();
			//	this.jta.append(infoma);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
/*	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				ObjectInputStream ois = new ObjectInputStream(ConnectToServer.s.getInputStream());
				try {
					Message mess = (Message)ois.readObject();
					String info = mess.getFrom()+":"+mess.getContent();
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
	}*/
}
