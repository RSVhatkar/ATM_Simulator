import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class SignupTwo extends JFrame implements ActionListener{
	
	JLabel additionalDetails,religion,category,income,educational,qualification,occupation,panno,adharno,seniorCitizen,existingAccount;
	JComboBox religionCombobox,categoryCombobox,incomeCombobox,educationalCombobox,occupationCombobox;
	JTextField panText,adharText;
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	
	String formno;
	
	SignupTwo(String formno)
	{
		this.formno=formno;
		
		setVisible(true);
		setLayout(null);
		setSize(850,800);
		setLocation(350,10);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		getContentPane().setBackground(Color.white);
		
		additionalDetails=new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		religion=new JLabel("Religion:");
		religion.setFont(new Font("Raleway",Font.BOLD,22));
		religion.setBounds(100,140, 100, 30);
		add(religion);
		
		String valReligion[]= {"Hindu","Muslim","Sikh","Christian","Other"};
		religionCombobox=new JComboBox(valReligion);
		religionCombobox.setBounds(360,140, 400, 30);
		religionCombobox.setBackground(Color.white);
		add(religionCombobox);
		
		category=new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD,22));
		category.setBounds(100, 190, 200, 30);
		add(category);
		
		String valcategory[]= {"SC","ST","OBC","NT"};
		categoryCombobox=new JComboBox(valcategory);
		categoryCombobox.setBounds(360,190,400,30);
		categoryCombobox.setBackground(Color.white);
		add(categoryCombobox);
		
		income=new JLabel("Income:");
		income.setFont(new Font("Raleway",Font.BOLD,22));
		income.setBounds(100,240, 200, 30);
		add(income);
		
		String valincome[]= {"Null","< 1,50,000","2,50,000","< 5,00,000","Upto 10,00,000"};
		incomeCombobox=new JComboBox(valincome);
		incomeCombobox.setBounds(360, 240, 400, 30);
		incomeCombobox.setBackground(Color.white);
		add(incomeCombobox);
		
		educational=new JLabel("Educational");
		educational.setFont(new Font("Raleway",Font.BOLD,22));
		educational.setBounds(100, 290, 200,30);
		add(educational);
		
		qualification=new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String valeducational[]= {"Non-Graduation","Graduate","Post-Graduation","Doctorate","Other"};
		educationalCombobox=new JComboBox(valeducational);
		educationalCombobox.setBackground(Color.white);
		educationalCombobox.setBounds(360,290,400,30);
		add(educationalCombobox);
		
		occupation=new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway",Font.BOLD,22));
		occupation.setBounds(100,390, 200, 30);
		add(occupation);
		
		String valoccupation[]= {"Salaried","Self Employed","Business","Student","Retired","Other"};
		occupationCombobox=new JComboBox(valoccupation);
		occupationCombobox.setBounds(360,390, 400, 30);
		occupationCombobox.setBackground(Color.white);
		add(occupationCombobox);
		
		panno=new JLabel("Pan No:");
		panno.setFont(new Font("Raleway",Font.BOLD,22));
		panno.setBounds(100, 440, 200, 30);
		add(panno);
		
		panText=new JTextField();
		panText.setFont(new Font("Raleway",Font.BOLD,22));
		panText.setBounds(360,440,400,30);
		add(panText);
		
		adharno=new JLabel("Adhar No:");
		adharno.setFont(new Font("Raleway",Font.BOLD,22));
		adharno.setBounds(100,490, 200, 30);
		add(adharno);
		
		adharText=new JTextField();
		adharText.setFont(new Font("Raleway",Font.BOLD,22));
		adharText.setBounds(360, 490, 400, 30);
		add(adharText);
		
		seniorCitizen=new JLabel("Senior Citizen:");
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD,22));
		seniorCitizen.setBounds(100,540,200, 30);
		add(seniorCitizen);
		
		syes=new JRadioButton("Yes");
		syes.setBounds(360,540,100,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(490,540,100,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup senior=new ButtonGroup();
		senior.add(syes);
		senior.add(sno);
		
		existingAccount=new JLabel("Existing Account:");
		existingAccount.setFont(new Font("Raleway",Font.BOLD,22));
		existingAccount.setBounds(100,590,200,30);
		add(existingAccount);
		
		eyes=new JRadioButton("Yes");
		eyes.setBackground(Color.white);
		eyes.setBounds(360,590,100,30);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBackground(Color.white);
		eno.setBounds(490,590,100,30);
		add(eno);
		
		ButtonGroup existing=new ButtonGroup();
		existing.add(eyes);
		existing.add(eno);
		
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
		String sreligion=(String) religionCombobox.getSelectedItem();
		String scategory=(String) categoryCombobox.getSelectedItem();
		String sincome=(String) incomeCombobox.getSelectedItem();
		String seducation=(String) educationalCombobox.getSelectedItem();
		String soccupation=(String) occupationCombobox.getSelectedItem();
		
		String seniorcitizenn=null;
		if(syes.isSelected())
		{
			seniorcitizenn="Yes";
		}
		else if(sno.isSelected())
		{
			seniorcitizenn="No";
		}
		
		String existingacc=null;
		if(eyes.isSelected())
		{
			existingacc="Yes";
		}
		else if(eno.isSelected())
		{
			existingacc="No";
		}
		
		String span=panText.getText();
		String sadhar=adharText.getText();
		
		try
		{
			Conn c=new Conn();
			String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizenn+"','"+existingacc+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	public static void main(String[] args) {
		new SignupTwo("");

	}

}
