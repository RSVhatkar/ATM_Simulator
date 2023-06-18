import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
public class Balanceenquiry extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton back;
	JLabel text,background;
	
	Balanceenquiry(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		ImageIcon img=new ImageIcon("images/atm.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,900,900);
		add(background);
			
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		background.add(back);
		back.addActionListener(this);
		
		Conn c=new Conn();
		int balance=0;
		try
		{
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while (rs.next()) 
			{
                if (rs.getString("type").equals("Deposite"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
			
			text=new JLabel("Your current account balance is: "+balance);
			text.setBounds(200,300,600,30);
			text.setForeground(Color.WHITE);
			text.setFont(new Font("Raleway",Font.BOLD,16));
			background.add(text);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		setSize(900,900);
		setLayout(null);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}

	public static void main(String[] args) {
		new Balanceenquiry("");

	}

}
