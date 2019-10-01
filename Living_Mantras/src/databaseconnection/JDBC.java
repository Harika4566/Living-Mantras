package databaseconnection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class  JDBC{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Connection conn=null;
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oracle","db");
	if(conn!=null) {
		System.out.println("Connected to databse");
		
	}
	else
	{
		System.out.println("Not connected");
	}
	
}catch(ClassNotFoundException e)
{
	e.printStackTrace();
}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}

}