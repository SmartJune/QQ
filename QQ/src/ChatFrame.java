import javax.swing.*;


public class ChatFrame extends JFrame{
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	public ChatFrame(String friend,String owner){
		jta = new JTextArea();
		jtf = new JTextField(30);
		jb = new JButton("send");
		jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		this.setTitle(owner +" is now chatting with "+friend);
		this.setSize(500,400);
		this.setVisible(true);
		
	}
}
