import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Withdrawal extends JFrame implements ActionListener{

	JLabel text,background;
	JTextField amount;
	JButton withdrawal,back;
	String pinnumber;
	
	Withdrawal(String pinnumber)
	{
		this.pinnumber=pinnumber;
				
		ImageIcon img=new ImageIcon("images/atm.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,900,900);
		add(background);
		
		text=new JLabel("Enter the amount you want to withdraw");
		text.setFont(new Font("Raleway",Font.BOLD,18));
		text.setForeground(Color.white);
		text.setBounds(170,300,400,20);
		background.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,22));
		amount.setBounds(170,350,320,30);
		background.add(amount);
		
		withdrawal=new JButton("Withdraw");
		withdrawal.setBounds(355,485,150,30);
		background.add(withdrawal);
		withdrawal.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		background.add(back);
		back.addActionListener(this);
		
		setSize(900,900);
		setUndecorated(true);
		setLayout(null);
		setLocation(300,0);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==withdrawal)
		{
			String number=amount.getText();
			Date date=new Date();
			if(amount.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}
			else
			{
				Conn c=new Conn();
				String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
				try
				{
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" withdraw successfully");
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
		}
		else if(ae.getSource()==back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Withdrawal("");

	}

}
