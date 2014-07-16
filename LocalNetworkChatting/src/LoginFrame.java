import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LoginFrame extends JFrame implements ActionListener{
	 JLabel nameLabel=new JLabel("用户名：");
	 JLabel passwordLabel=new JLabel("密码：");
	 JTextField name=new JTextField(10), password=new JTextField(10);
	 JButton sureButton=new JButton("确定");
	 JButton cancelButton=new JButton("取消");
	 JButton signUpButton=new JButton("注册");
	 public LoginFrame() {
		 super("登录");
		 setVisible(true);
		 setBounds(500, 200, 280, 220);
		 setLayout(null);
		 
		 nameLabel.setBounds(45, 20, 100, 25);
		 add(nameLabel);
		 add(name);
		 name.setBounds(105, 20, 110, 25);
		 
		 add(passwordLabel);
		 passwordLabel.setBounds(45, 60, 100, 25);
		 add(password);
		 password.setBounds(105, 60, 110, 25);
		 
		 add(sureButton);
		 sureButton.setBounds(20, 100, 80, 25);
		 
		 add(cancelButton);
		 cancelButton.setBounds(100, 100, 80, 25);
		 
		 add(signUpButton);
		 signUpButton.setBounds(180,100,80,25);
		 
		 sureButton.addActionListener(this);
		 cancelButton.addActionListener(this);
		  
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 validate();//刷新
	}
	 public void actionPerformed(ActionEvent e) {
		 if (e.getSource() ==sureButton){
			 boolean permissionDeny = false;
			 //验证用户名和密码
			 //需要提供一个用户注册和身份验证的功能
			 if(permissionDeny == true){
				this.dispose();
				new ChatFrame();
			 }
			 else{
				JOptionPane.showMessageDialog(this, "用户名或密码错误!");
			 }
		 }
		 else if(e.getSource()==cancelButton){
			 System.exit(1);
		  }
		 else if(e.getSource()==signUpButton){
			 //注册新用户功能
		 }
		 }
}
