import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
	
	JLabel text,background;
	JButton deposite,withdrawal,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinnumber;
	
	Transactions(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("images/atm.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,900,900);
		add(background);
		
		text=new JLabel("Please select your transaction");
		text.setBounds(225,300,700,35);
		text.setFont(new Font("Raleway",Font.BOLD,18));
		text.setForeground(Color.white);
		background.add(text);
		
		deposite=new JButton("Deposite");
		deposite.setBounds(170,415,150,30);
		background.add(deposite);
		deposite.addActionListener(this);
		
		withdrawal=new JButton("Withdrawal");
		withdrawal.setBounds(355,415,150,30);
		background.add(withdrawal);
		withdrawal.addActionListener(this);
		
		fastcash=new JButton("Fast Cash");
		fastcash.setBounds(170,450,150,30);
		background.add(fastcash);
		fastcash.addActionListener(this);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBounds(355,450,150,30);
		background.add(ministatement);
		ministatement.addActionListener(this);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBounds(170,485,150,30);
		background.add(pinchange);
		pinchange.addActionListener(this);
		
		balanceenquiry=new JButton("Balance enquiry");
		balanceenquiry.setBounds(355,485,150,30);
		background.add(balanceenquiry);
		balanceenquiry.addActionListener(this);
		
		exit=new JButton("Exit");
		exit.setBounds(355,520,150,30);
		background.add(exit);
		exit.addActionListener(this);
		
		setLayout(null);
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()==deposite)
		{
			setVisible(true);
			new Deposite(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==withdrawal)
		{
			setVisible(false);
			new Withdrawal(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==fastcash)
		{
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==pinchange)
		{
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==balanceenquiry)
		{
			setVisible(false);
			new Balanceenquiry(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==ministatement)
		{
			new Ministatement(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Transactions("");

	}

}
