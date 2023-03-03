package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class WConnection {
 Connection con=null;
 Statement s;
	public WConnection(){
		
		try
		{
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
			s =con.createStatement();
			if(con!=null)
			{
				System.out.println("database is connected");
			}
		}catch(Exception e)
		{
			System.out.println("not connected");
		}

	}
	public CallableStatement prepareCall(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
