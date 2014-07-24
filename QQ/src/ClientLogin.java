import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;


public class ClientLogin extends JFrame implements ActionListener{
	
	//north
	JLabel northLabel;
	//center
	JPanel centerPanel;
	JTextField numb;
	JPasswordField pswd;
	JCheckBox remember,hide;
	JLabel number,password;
	//south
	JPanel southPanel;
	JButton login,cancel,signIn;
	
	public ClientLogin(){
		//north
		northLabel = new JLabel("Thanks to K,Jovn and friends from Bug Clan",JLabel.CENTER);
		//center
		centerPanel = new JPanel(new GridLayout(3,2));
		number = new JLabel("QQ number",JLabel.CENTER);
		password = new JLabel("QQ password",JLabel.CENTER);
		numb = new JTextField();
		pswd = new JPasswordField();
		remember = new JCheckBox("remember");
		hide = new JCheckBox("hide");
		centerPanel.add(number);
		centerPanel.add(numb);
		centerPanel.add(password);
		centerPanel.add(pswd);
		centerPanel.add(remember);
		centerPanel.add(hide);
		//south
		login = new JButton("login");
		login.addActionListener(this);	//login listener
		cancel = new JButton("cancel");
		cancel.addActionListener(this);
		signIn = new JButton("sign in");
		signIn.addActionListener(this);
		southPanel = new JPanel();
		southPanel.add(login);
		southPanel.add(cancel);
		southPanel.add(signIn);
		
		this.add(northLabel,"North");
		this.add(southPanel,"South");
		this.add(centerPanel,"Center");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		pack();
		
	}
	
	public static void main(String[] args){
		ClientLogin clientLogin = new ClientLogin();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == login){
			LoginCheck lc = new LoginCheck();
			User u = new User();
			u.setUserId(numb.getText().trim());
			u.setPassword(new String(pswd.getPassword()));
			
			if(lc.checkUser(u)){
				//online friend list request
				try {
					ObjectOutputStream oos =  new ObjectOutputStream(ClientThreadManager
							.getClientThread(u.getUserId()).getSocket().getOutputStream());
					
					Message mess = new Message();
					mess.setMessageType(MessageType.getOnlineList);
					mess.setFrom(u.getUserId());
					mess.setTo(u.getPassword());
					oos.writeObject(mess);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				new OnlineList(u.getUserId());
				this.dispose();	
			}
			else{
				JOptionPane.showMessageDialog(this,"Name or password error!or server doesn't response truely");
			}
		}
		else if (arg0.getSource() == cancel){
			this.dispose();
		}
		else if (arg0.getSource() == signIn){
			JOptionPane.showMessageDialog(this,"Function has not available now");			
		}
	}
	
}