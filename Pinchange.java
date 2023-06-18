import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class Pinchange extends JFrame implements ActionListener{
	
	String pinnumber;
	JLabel text,pintext,repintext,background;
	JPasswordField pin,repin;
	JButton change,back;
	
	Pinchange(String pinnumber)
	{
		this.pinnumber=pinnumber;
		
		ImageIcon img=new ImageIcon("images/atm.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,900,900);
		add(background);
				
		text=new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("Raleway",Font.BOLD,22));
		text.setForeground(Color.white);
		text.setBounds(230,250,500,35);
		background.add(text);
		
		pintext=new JLabel("New PIN:");
		pintext.setFont(new Font("Raleway",Font.BOLD,16));
		pintext.setForeground(Color.white);
		pintext.setBounds(165,320,180,25);
		background.add(pintext);
		
		pin=new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,18));
		pin.setBounds(330,320,180,25);
		background.add(pin);
		
		repintext=new JLabel("Re-enter New PIN:");
		repintext.setFont(new Font("Raleway",Font.BOLD,16));
		repintext.setForeground(Color.white);
		repintext.setBounds(165,360,180,25);
		background.add(repintext);
		
		repin=new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,18));
		repin.setBounds(330,360,180,25);
		background.add(repin);
		
		change=new JButton("Change");
		change.setBounds(355,485,150,30);
		background.add(change);
		change.addActionListener(this);
		
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
		if(ae.getSource()==change)
		{
			try
			{
				String npin=pin.getText();
				String nrepin=repin.getText();
				if(!npin.equals(nrepin))
				{
					JOptionPane.showMessageDialog(null,"Entered pin doesn't match");
					return;
				}
				if(npin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter new pin");
					return;
				}
				if(nrepin.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please re-enter new pin");
					return;
				}
				
				Conn c=new Conn();
				String query1="update bank set pin= '"+npin+"' where pin= '"+pinnumber+"' ";
				String query2="update login set pin= '"+npin+"' where pin= '"+pinnumber+"' ";
				String query3="update signupthree set pinnumber= '"+npin+"' where pinnumber= '"+pinnumber+"' ";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin changed successfully");
				
				setVisible(false);
				new Transactions(npin).setVisible(true);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Pinchange("");

	}

}
