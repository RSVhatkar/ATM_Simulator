import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

	JLabel accountDetails,type,cardno,number,pin,pnumber,carddetail,pindetail,services;
	JRadioButton savingaccount,fixeddepositeaccount,currentaccount,recurringaccount;
	JCheckBox atmcard,internetbanking,mobilebanking,emailsmsalert,chequebook,estatement,declare;	
	JButton submit,cancel;
	String formno;
	
	SignupThree(String formno)
	{
		this.formno=formno;
		
		setVisible(true);
		setLayout(null);
		setSize(850,800);
		setLocation(350,10);
		
		getContentPane().setBackground(Color.white); //to change background color of frame
		
		accountDetails=new JLabel("Page 3: Account Details");
		accountDetails.setBounds(250,40,400,40);
		accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
		add(accountDetails);
		
		type=new JLabel("Account Type:");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		savingaccount=new JRadioButton("Saving Account");
		savingaccount.setFont(new Font("Raleway",Font.BOLD,16));
		savingaccount.setBounds(100,180,200,30);
		savingaccount.setBackground(Color.white);
		add(savingaccount);
		
		fixeddepositeaccount=new JRadioButton("Fixed Deposite Account");
		fixeddepositeaccount.setFont(new Font("Raleway",Font.BOLD,16));
		fixeddepositeaccount.setBounds(350,180,250,20);
		fixeddepositeaccount.setBackground(Color.white);
		add(fixeddepositeaccount);
		
		currentaccount=new JRadioButton("Current Account");
		currentaccount.setFont(new Font("Raleway",Font.BOLD,16));
		currentaccount.setBounds(100,220,250,20);
		currentaccount.setBackground(Color.white);
		add(currentaccount);
		
		recurringaccount=new JRadioButton("Recurring Account");
		recurringaccount.setFont(new Font("Raleway",Font.BOLD,16));
		recurringaccount.setBackground(Color.white);
		recurringaccount.setBounds(350,220,250,20);
		add(recurringaccount);
		
		ButtonGroup accounttype=new ButtonGroup();
		accounttype.add(savingaccount);
		accounttype.add(fixeddepositeaccount);
		accounttype.add(currentaccount);
		accounttype.add(recurringaccount);
		
		cardno=new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,22));
		cardno.setBounds(100,300,200,30);
		add(cardno);
		
		number=new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,300,250,30);
		add(number);
		
		carddetail=new JLabel("Your 16 digit card number");
		carddetail.setFont(new Font("Raleway",Font.BOLD,12));
		carddetail.setBounds(100,330,300,30);
		add(carddetail);
		
		pin=new JLabel("Pin");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,370,200,30);
		add(pin);
		
		pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway",Font.BOLD,22));
		pnumber.setBounds(330,370,360,30);
		add(pnumber);
		
		pindetail=new JLabel("Your 4 digit password");
		pindetail.setFont(new Font("Raleway",Font.BOLD,12));
		pindetail.setBounds(100,400,300,20);
		add(pindetail);
		
		services=new JLabel("Services required:");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,450,200,20);
		add(services);
		
		atmcard=new JCheckBox("ATM card");
		atmcard.setFont(new Font("Raleway",Font.BOLD,16));
		atmcard.setBounds(100,500,200,30);
		atmcard.setBackground(Color.white);
		add(atmcard);
		
		internetbanking=new JCheckBox("Internet Banking");
		internetbanking.setFont(new Font("Raleway",Font.BOLD,16));
		internetbanking.setBounds(350,500,200,30);
		internetbanking.setBackground(Color.white);
		add(internetbanking);
		
		mobilebanking=new JCheckBox("Mobile Banking");
		mobilebanking.setFont(new Font("Raleway",Font.BOLD,16));
		mobilebanking.setBounds(100,550,200,30);
		mobilebanking.setBackground(Color.white);
		add(mobilebanking);
		
		emailsmsalert=new JCheckBox("Email and SMS alert");
		emailsmsalert.setFont(new Font("Raleway",Font.BOLD,16));
		emailsmsalert.setBounds(350,550,200,30);
		emailsmsalert.setBackground(Color.white);
		add(emailsmsalert);
		
		chequebook=new JCheckBox("Cheque Book");
		chequebook.setFont(new Font("Raleway",Font.BOLD,16));
		chequebook.setBounds(100,600,200,30);
		chequebook.setBackground(Color.white);
		add(chequebook);
		
		estatement=new JCheckBox("EStatement");
		estatement.setFont(new Font("Raleway",Font.BOLD,16));
		estatement.setBounds(350,600,200,30);
		estatement.setBackground(Color.white);
		add(estatement);
		
		declare=new JCheckBox("I hereby declare that the above entered details are correct to best of my knowledge");
		declare.setFont(new Font("Raleway",Font.BOLD,12));
		declare.setBounds(100,680,600,30);
		declare.setBackground(Color.white);
		add(declare);
		
		submit=new JButton("Submit");
		submit.setBounds(200,720,100,30);
		submit.setFont(new Font("Raleway",Font.BOLD,14));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setFont(new Font("Raleway",Font.BOLD,14));
		cancel.setBounds(420,720,100,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			String accountType=null;
			if(savingaccount.isSelected())
			{
				accountType="Saving Account";
			}
			else if(fixeddepositeaccount.isSelected())
			{
				accountType="Fixed Deposite Account";
			}
			else if(currentaccount.isSelected())
			{
				accountType="Current Account";
			}
			else if(recurringaccount.isSelected())
			{
				accountType="Recurring Account";
			}
			
			Random random=new Random();
			String cardnumber="" + Math.abs((random.nextLong() % 9000000L) + 5040936000000000L); //to generate cardno
			String pinnumber="" + Math.abs((random.nextLong() % 9000L) + 1000L); //to generate pin no
			
			String facility="";
			if(atmcard.isSelected())
			{
				facility=facility+" ATM Card";
			}
			if(internetbanking.isSelected())
			{
				facility=facility+" InternetBanking";
			}
			if(mobilebanking.isSelected())
			{
				facility=facility+" Mobile Banking";
			}
			if(emailsmsalert.isSelected())
			{
				facility=facility+" Email and SMS alert";
			}
			if(chequebook.isSelected())
			{
				facility=facility+" Cheque Book";
			}
			if(estatement.isSelected())
			{
				facility=facility+" EStatement";
			}
			
			try
			{
				if(accountType.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Account type is required");
				}
				else
				{
					Conn c=new Conn();
					String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					c.s.executeUpdate(query1);
					
					String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n"+"Pin Number: "+pinnumber);
					
					setVisible(false);
					new Deposite(pinnumber).setVisible(true);
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
		else if(ae.getSource()==cancel)
		{
			setVisible(false);
			new Login().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new SignupThree("");

	}

}
