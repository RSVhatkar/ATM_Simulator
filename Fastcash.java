import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
	
	JLabel text,background;
	JButton hundred,fivehundred,onethousand,twothousand,fivethousand,tenthousand,back;
	String pinnumber;
	
	Fastcash(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		ImageIcon img=new ImageIcon("images/atm.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,900,900);
		add(background);
		
		text=new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setBounds(170,300, 700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD,22));
		background.add(text);
		
		hundred=new JButton("Rs 100");
		hundred.setBounds(170,415,150,30);
		background.add(hundred);
		hundred.addActionListener(this);
		
		fivehundred=new JButton("Rs 500");
		fivehundred.setBounds(355,415,150,30);
		background.add(fivehundred);
		fivehundred.addActionListener(this);
		
		onethousand=new JButton("Rs 1000");
		onethousand.setBounds(170,450,150,30);
		background.add(onethousand);
		onethousand.addActionListener(this);
		
		twothousand=new JButton("Rs 2000");
		twothousand.setBounds(355,450,150,30);
		background.add(twothousand);
		twothousand.addActionListener(this);
		
		fivethousand=new JButton("Rs 5000");
		fivethousand.setBounds(170,485,150,30);
		background.add(fivethousand);
		fivethousand.addActionListener(this);
		
		tenthousand=new JButton("Rs 10000");
		tenthousand.setBounds(355,485,150,30);
		background.add(tenthousand);
		tenthousand.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		background.add(back);
		back.addActionListener(this);
				
		setLayout(null);
		setSize(900,900);
		setLocation(350,0);
		setUndecorated(true);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else
		{
			String amount = ((JButton)ae.getSource()).getText().substring(3);  //get text of clicked button eg Rs 500 etc substring used to remove Rs word
			Conn c=new Conn();
			try
			{
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance=0;
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
				
				if (ae.getSource() != back && balance < Integer.parseInt(amount))
				{
		             JOptionPane.showMessageDialog(null, "Insuffient Balance");
		             return;
		        }
							
				Date date=new Date();
				c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')");
	            JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
	
	public static void main(String[] args) {
		new Fastcash("");

	}

}