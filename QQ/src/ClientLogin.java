import java.awt.*;
import javax.swing.*;


public class ClientLogin extends JFrame{
	
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
		northLabel = new JLabel("\n"+"Welcome to use QQ for linux"+"\n",JLabel.CENTER);
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
		cancel = new JButton("cancel");
		signIn = new JButton("sign in");
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
	
}