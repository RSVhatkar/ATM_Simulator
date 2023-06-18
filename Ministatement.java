import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.*;
public class Ministatement extends JFrame{
	
	String pinnumber;
	JLabel mini,bank,card,balance;
	
	Ministatement(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		setTitle("Mini Statement");
		setSize(400,600);
		setLocation(20,20);
		setLayout(null);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		
		mini=new JLabel();
		add(mini);
		
		bank=new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		card=new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		balance=new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		//to fetch card no from login table
		try
		{
			Conn c=new Conn();
			String query="select * from login where pin= '"+pinnumber+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" +rs.getString("cardnumber").substring(12));
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		//to get transactions from bank table
		try
		{
			int bal= 0;
	        Conn c  = new Conn();
	        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
	        while(rs.next())
	        {
	        	mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
	        	if(rs.getString("type").equals("Deposite"))
	            {
	            	bal += Integer.parseInt(rs.getString("amount"));
	            }
	            else
	            {
	                bal -= Integer.parseInt(rs.getString("amount"));
	            }
	        }
	        mini.setBounds(20,140,400,200);
	        balance.setText("Your current account balance is Rs "+bal);
	        }
		 	catch(Exception e)
		 	{
	            System.out.print(e);
	        }
	}

	public static void main(String[] args) {
		new Ministatement("");

	}

}
