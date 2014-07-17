import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class ChatFrame extends JFrame{
	
	TextField textField = new TextField();
	TextArea textArea = new TextArea();
	
	public ChatFrame(){
		super("聊天");
		setLocation(400,300);
		this.setSize(300,300);
		add(textField,BorderLayout.SOUTH);
		add(textArea,BorderLayout.NORTH);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField.addActionListener(new TextFieldListener());
		setVisible(true);
	}
	private class TextFieldListener implements ActionListener{
	@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			String s = textField.getText().trim();
			textArea.setText(s);
			textField.setText("");
		}	
	}
}
