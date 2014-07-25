import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class OnlineList extends JFrame implements ActionListener,MouseListener{
	//friend list
	JPanel mainPanel,listPanel,buttonPanel;
	JButton friend,stranger,blackList;
	JScrollPane jsp;
	//stranger list
	JPanel mainPanel2,listPanel2,buttonPanel2;
	JButton friend2,stranger2,blackList2;
	JScrollPane jsp2;
	
	CardLayout card;

	String userId;
	
	JLabel[] jlbs;
	JLabel[] jlbs2;
	
	public OnlineList(String userID){
		//friend list
		mainPanel = new JPanel(new BorderLayout());	
		int userNumber = 30;
		listPanel = new JPanel(new GridLayout(userNumber,1,4,4));	
		jlbs = new JLabel[userNumber];
		for(int i = 0;i<jlbs.length;i++){
			jlbs[i] = new JLabel(i+1+"",new ImageIcon("icon/onLine.jpg"),JLabel.LEFT);
	//		Icon icon = new ImageIcon("home/workspace/qq/src/onLine.jpg");
	//		jlbs[i].setIcon(icon);
			jlbs[i].addMouseListener(this);
			jlbs[i].setEnabled(false);
	//		jlbs[i].setForeground(Color.BLACK);
			listPanel.add(jlbs[i]);
			if(jlbs[i].getText().equals(userID)){
				jlbs[i].setEnabled(true);
			}
		}
		jsp = new JScrollPane(listPanel);
		friend = new JButton("Friend List");
		stranger = new JButton("Stranger List");
		stranger.addActionListener(this);
		
		blackList = new JButton("BlackList List");
		buttonPanel = new JPanel(new GridLayout(2,1));
		buttonPanel.add(stranger);
		buttonPanel.add(blackList);
		mainPanel.add(friend,"North");
		mainPanel.add(jsp,"Center");
		mainPanel.add(buttonPanel,"South");
		
		//stranger list
		mainPanel2 = new JPanel(new BorderLayout());	
		int strangerNumber = 30;
		listPanel2 = new JPanel(new GridLayout(strangerNumber,1,4,4));	
		jlbs2 = new JLabel[strangerNumber];
		for(int i = 0;i<jlbs2.length;i++){
			jlbs2[i] = new JLabel(userNumber+i+1+"",new ImageIcon("icon/onLine.jpg"),JLabel.LEFT);
		//	Icon icon = new ImageIcon("home/workspace/qq/src/onLine.jpg");
		//	jlbs2[i].setIcon(icon);
		//j lbs2[i].setForeground(Color.BLACK);
			jlbs2[i].setEnabled(false);
			if(jlbs2[i].getText().equals(userID)){
				jlbs2[i].setEnabled(true);
			}
			jlbs2[i].addMouseListener(this);
			listPanel2.add(jlbs2[i]);
		}
		jsp2 = new JScrollPane(listPanel2);
		friend2 = new JButton("Friend List");
		friend2.addActionListener(this);
		stranger2 = new JButton("Stranger List");
		blackList2 = new JButton("Blacklist List");
		buttonPanel2 = new JPanel(new GridLayout(2,1));
		buttonPanel2.add(friend2);
		buttonPanel2.add(stranger2);	
		mainPanel2.add(blackList2,"South");
		mainPanel2.add(jsp2,"Center");
		mainPanel2.add(buttonPanel2,"North");
		
		card = new CardLayout();
		this.setLayout(card);
		this.add(mainPanel,"1");
		this.add(mainPanel2,"2");
		
		this.userId = userID;
		
		this.setTitle(userID);
		this.setSize(300,600);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==stranger){
			card.show(this.getContentPane(),"2");
		}
		else if(e.getSource()==friend2){
			card.show(this.getContentPane(),"1");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getClickCount()==2){
			//get his id
			String friendId = ((JLabel)arg0.getSource()).getText();
	//		String ownerId;
			ChatFrame cf = new ChatFrame(friendId,userId);
			ChatFrameManager.addChatFrame(userId+" "+friendId, cf);
	/*		Thread t = new Thread(cf);
			t.start();  */
			}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel j1 = (JLabel)arg0.getSource();
		j1.setForeground(Color.green);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel j1 = (JLabel)arg0.getSource();
		j1.setForeground(Color.black);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateList(Message mess){
		String list[] = mess.getContent().split(" ");
		for(int i = 0;i<list.length;i++){
			System.out.println(list[i]);
			jlbs[Integer.parseInt(list[i])-1].setEnabled(true);
		}
	}
	
}
