import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ServerFrame extends JFrame implements ActionListener{
	
	JPanel jp;
	JButton jb1,jb2;
	
	public ServerFrame(){
		jp = new JPanel();
		jb1 = new JButton("start the server");
		jb1.addActionListener(this);
		jb2 = new JButton("close the server");
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new ServerFrame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == jb1){
			new QqServer();
		}
	}
	
}
