import java.sql.*;
public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); //register driver
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsimulator","root","root"); //establish connection
			s=c.createStatement();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}