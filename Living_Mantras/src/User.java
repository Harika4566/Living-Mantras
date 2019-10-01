
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import databaseconnection.Tips;

public class User {


	public void task()
	{
		Scanner sc =new Scanner(System.in);
		Tips u=new Tips();
		System.out.println("user");
		System.out.println("Login");
		int option;
	
		/*System.out.println("Enter your credentials");
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		System.out.println("Logged in successfull");*/
		
		System.out.println("Your task");
		System.out.println(" 1.Register");
		System.out.println("2.login");
		
		
		System.out.println("Enter option");
		option=sc.nextInt();
		switch(option)
		{
		case 1:
		
			try {
				Connection conn;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oracle","db");
				Statement st=conn.createStatement();
				
				PreparedStatement ps=conn.prepareStatement("insert into registration values(?,?,?,?,?)");
				System.out.println("database connectivity is successfull");
			
				System.out.println("enter name");
				String name=sc.next();
				System.out.println("enter gender");
				String gender=sc.next();
				System.out.println("enter age");
				int age=sc.nextInt();System.out.println("enter mail_id");
				String mail_id=sc.next();
				
				
				System.out.println("enter contact number");
				long phone_no=sc.nextLong();
				
				
				ps.setString(1,name);
				ps.setString(2,gender);
				ps.setInt(3,age);
				ps.setString(4,mail_id);
				ps.setLong(5,phone_no);
			
				
				ps.executeUpdate();
				ResultSet rs=st.executeQuery("SELECT * from registration");
				System.out.println("NAME"+"\t\t        "+"GENDER"+"\t"+"AGE"+"\t"+"MAIL_ID"+"\t"+"PHONE_NO");
				while(rs.next())
				{
					System.out.print(rs.getString(1) + "     ");
					System.out.print(rs.getString(2) + " ");
					System.out.print(rs.getInt(3) + " ");
				
					System.out.print(rs.getString(4) + "\t\t  ");
					System.out.print(rs.getLong(5) + "      ");
					System.out.println();
					
				}
			u.healthy();
				conn.close();
			}
			catch(Exception e)
			{
				System.err.println("Got an exceptional");
			}

		
			break;
		case 2:	
			try {
			Connection conn;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","oracle","db");
			Statement st=conn.createStatement();
			
			System.out.println("user");
			System.out.println("login");
		System.out.println("Enter your credentials");
			System.out.println("Enter username");
			String USER_NAME=sc.next();
			System.out.println("Enter password");
			String PASSWORD=sc.next();
			ResultSet rs=st.executeQuery("SELECT USER_NAME from login ");
			System.out.println("USER_NAME");
			System.out.println("----------------------------------------------------------------");
			while(rs.next())
			{
				System.out.print(rs.getString(1) + "\t");
				
			    System.out.println();
			}
		u.healthy();
			conn.close();
		}
		catch(Exception e)
		{
			System.err.println("Got an exceptional");
		}
		break;
			
		
		
	}
}
}