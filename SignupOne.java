import java.awt.Color;
import java.awt.Font;
import java.util.*;//for random class
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.*; //for jcalender
import com.toedter.calendar.JDateChooser;//for JDateChooser
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField nametext,fnametext,emailtext,addresstext,citytext,statetext,pintext;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser datechooser;
	
	SignupOne()
	{
		setSize(850,800);
		setLayout(null);
		setVisible(true);
		setLocation(350,10);
		
		getContentPane().setBackground(Color.white);
		
		Random ran=new Random();
		random=Math.abs((ran.nextLong()%9000L)+1000L);
		
		JLabel formno=new JLabel("APPLICATION FORM NO: "+random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personalDetails=new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		personalDetails.setBounds(290, 80, 400, 30);
		add(personalDetails);
		
		JLabel name=new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,22));
		name.setBounds(100, 140,100,30);
		add(name);
		
		nametext=new JTextField();
		nametext.setFont(new Font("Raleway",Font.BOLD,14));
		nametext.setBounds(300, 140,400,30);
		add(nametext);
		
		JLabel fname=new JLabel("Father's name:");
		fname.setFont(new Font("Raleway",Font.BOLD,22));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnametext=new JTextField();
		fnametext.setFont(new Font("Raleway",Font.BOLD,14));
		fnametext.setBounds(300,190,400,30);
		add(fnametext);
		
		JLabel dob=new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,22));
		dob.setBounds(100, 240, 200,30);
		add(dob);
		
		datechooser=new JDateChooser();
		datechooser.setBounds(300, 240, 400, 30);
		add(datechooser);
		
		JLabel gender=new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,22));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450, 290, 80, 30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup=new ButtonGroup(); //to choose only 1 radio button
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel emailaddress=new JLabel("Email Address:");
		emailaddress.setFont(new Font("Raleway",Font.BOLD,22));
		emailaddress.setBounds(100, 340, 200, 30);
		add(emailaddress);
		
		emailtext=new JTextField();
		emailtext.setFont(new Font("Raleway",Font.BOLD,14));
		emailtext.setBounds(300,340,400,30);
		add(emailtext);
		
		JLabel martialstatus=new JLabel("Maritial Status:");
		martialstatus.setFont(new Font("Raleway",Font.BOLD,22));
		martialstatus.setBounds(100, 390, 200, 30);
		add(martialstatus);
		
		married=new JRadioButton("Married");
		married.setBounds(300, 390, 100,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390, 100, 30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other=new JRadioButton("Other");
		other.setBounds(630, 390, 100, 30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup maritialgroup=new ButtonGroup();
		maritialgroup.add(married);
		maritialgroup.add(unmarried);
		maritialgroup.add(other);
		
		JLabel address=new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,22));
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addresstext=new JTextField();
		addresstext.setFont(new Font("Raleway",Font.BOLD,14));
		addresstext.setBounds(300,440,400,30);
		add(addresstext);
		
		JLabel city=new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,22));
		city.setBounds(100, 490, 200, 30);
		add(city);
		
		citytext=new JTextField();
		citytext.setFont(new Font("Raleway",Font.BOLD,14));
		citytext.setBounds(300,490,400,30);
		add(citytext);
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,22));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		statetext=new JTextField();
		statetext.setFont(new Font("Raleway",Font.BOLD,14));
		statetext.setBounds(300,540,400,30);
		add(statetext);
		
		JLabel pincode=new JLabel("Pin code:");
		pincode.setFont(new Font("Raleway",Font.BOLD,22));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		pintext=new JTextField();
		pintext.setFont(new Font("Raleway",Font.BOLD,14));
		pintext.setBounds(300, 590, 400,30);
		add(pintext);
		
		next=new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620, 660, 80, 30);
		add(next);
		next.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String formno=""+random;
		String name=nametext.getText();
		String fname=fnametext.getText();
		String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		
		String gender=null;
		if(male.isSelected())
		{
			gender="Male";
		}
		else if(female.isSelected())
		{
			gender="Female";
		}
		
		String email=emailtext.getText();
		
		String maritial=null;
		if(married.isSelected())
		{
			maritial="Married";
		}
		else if(unmarried.isSelected())
		{
			maritial="Unmarried";
		}
		else if(other.isSelected())
		{
			maritial="Other";
		}
		
		String address=addresstext.getText();
		String city=citytext.getText();
		String state=statetext.getText();
		String pin=pintext.getText();
		
		try
		{
			Conn c=new Conn();
			String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
			c.s.executeUpdate(query);
			
			setVisible(false); //to close current frame
			new SignupTwo(formno).setVisible(true); //passed formno  to next page as it is primary key
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	
	public static void main(String[] args) {
		new SignupOne();

	}

}
