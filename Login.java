import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{

	JButton login,clear,signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login()
	{
		setTitle("AUTOMATED TELLER MACHINE");
		setSize(800,480);
		setVisible(true);
		setLayout(null);
		setLocation(350,200); //opens frame at this location
		
		getContentPane().setBackground(Color.WHITE);//to set white background color of frame
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(200, 60, 400, 40);
		add(text);
		
		JLabel cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300, 150, 230 , 30);
		cardTextField.setFont(new Font("Raleway",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("Pin:");
		pin.setFont(new Font("Raleway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300,220, 230, 30);
		pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
		add(pinTextField);
		
		login=new JButton("Sign in");
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.setBounds(300, 300, 100, 30);
		add(login);
		login.addActionListener(this);
		
		clear=new JButton("Clear");
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.setBounds(430,300,100,30);
		add(clear);
		clear.addActionListener(this);
		
		signup=new JButton("Sign up");
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.setBounds(300, 350, 230, 30);
		add(signup);
		signup.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clear)
		{
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(ae.getSource()==login)
		{
			Conn c=new Conn();
			String cardnumber=cardTextField.getText();
			String pinnumber=pinTextField.getText();
			String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
			try
			{
				ResultSet rs=c.s.executeQuery(query);
				if(rs.next())
				{
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect card or pin");
					cardTextField.setText("");
					pinTextField.setText("");
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else if(ae.getSource()==signup)
		{
			setVisible(false); //to close current frame
			new SignupOne().setVisible(true); //to open signup frame
		}
	}
	
	
	public static void main(String[] args) {
		new Login(); //creating obj of Login class

	}

	

}
