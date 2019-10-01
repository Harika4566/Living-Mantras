


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	

	
	public void task() {
		// TODO Auto-generated method stub
		System.out.println("admin");
		System.out.println("login");
		Scanner sc=new Scanner(System.in);
		int option;
		System.out.println("Enter your credentials");
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		if(username.equals("admin") && username.equals("admin"))
		{
			System.out.println("Logged in successfull");
			System.out.println("Your task");
			System.out.println("1. Entry of employee");
			System.out.println("2. Feedback");
			System.out.println("Enter option");
			option=sc.nextInt();
			switch(option)
			{
				case 1:
			
					//insertinto empfrmadmin table;
					System.out.println("Would you like to enter these as memeber of carpooling?");
					System.out.println("Type 1 if YES                2 if NO");
					int opt=sc.nextInt();
					if(opt==1)
					{
					
					try {
						Connection conn;
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADMIN","root1");
						Statement st=conn.createStatement();
						
						PreparedStatement ps=conn.prepareStatement("insert into employeedfrmadm values(?,?,?,?,?,?,?,?)");
						System.out.println("database connectivity is successfull");
						System.out.println("enter jobid");
						String jobid=sc.next();
						System.out.println("enter carpid");
						String carpid=sc.next();
						
						System.out.println("enter name");
						String name=sc.next();
						System.out.println("enter gender");
						String gender=sc.next();
						System.out.println("enter contact number");
						long contactnum=sc.nextLong();
						System.out.println("enter vehicle number");
						String vehiclenum=sc.next();
						System.out.println("enter vehicle registration number");
						String vehicleregnum=sc.next();
						System.out.println("enter address");
						String address=sc.next();
						ps.setString(1,jobid);
						ps.setString(2, carpid);
						ps.setString(3,name);
						ps.setString(4,gender);
						ps.setLong(5,contactnum);
						ps.setString(6,vehiclenum);
						ps.setString(7,vehicleregnum);
						ps.setString(8,address);
						
						ps.executeUpdate();
						ResultSet rs=st.executeQuery("SELECT * from employeed");
						System.out.println("JOBID"+"\t "+""+"CARPID"+"\t"+"NAME"+"\t\t        "+"GENDER"+"\t"+"CONTACT NUM"+"\t"+"VEHICLE NUM"+"\t"+"VEHICLEREG NUM"+"\t"+"ADDRESS");
						while(rs.next())
						{
							System.out.print(rs.getString(1) + "     ");
							System.out.print(rs.getString(2) + " ");
							System.out.print(rs.getString(3) + " ");
							System.out.print(rs.getLong(4) + "      ");
							System.out.print(rs.getString(5) + "\t\t  ");
							System.out.print(rs.getString(6) + "\t   ");
							System.out.print(rs.getString(7) + " ");
							System.out.println();
							
						}
					
						conn.close();
					}
					catch(Exception e)
					{
						System.err.println("Got an exceptional");
					}
					}
					break;
			
				case 2:
					//	feedback table entry();
					try {
						Connection conn;
						Class.forName("oracle.jdbc.driver.OracleDriver");
						conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADMIN","root1");
						Statement st=conn.createStatement();
						
						PreparedStatement ps=conn.prepareStatement("insert into feedback values(?,?,?,?,?)");
						System.out.println("database connectivity is successfull");
						System.out.println("enter jobidemp");
						String jobidemp=sc.next();
						System.out.println("enter carpid");
						String carpid=sc.next();
						System.out.println("enter day");
						String day=sc.next();
						System.out.println("enter droptime");
						String droptime=sc.next();
						System.out.println("enter Feedback or Suggestion");
						String feedbackorsugg=sc.next();
						
						ps.setString(1,jobidemp);
						ps.setString(2,carpid);
						ps.setString(3,day);
						ps.setString(4,droptime);
						ps.setString(5,feedbackorsugg);
						
						ps.executeUpdate();
						ResultSet rs=st.executeQuery("SELECT * from feedback");
						System.out.println("JOBIDEMP"+"\t"+"CARPID"+"\t"+"DAY"+"\t\t"+"DROP_TIME"+"\t "+"FEEDBACK_OR_SUGGESTION");
						System.out.println("-----------------------------------------------------------------");
						while(rs.next())
						{
							System.out.print(rs.getString(1) + "\t\t");
							System.out.print(rs.getString(2) + "\t");
							System.out.print(rs.getString(3) + "\t");
							System.out.print(rs.getString(4) + "\t");
							System.out.print(rs.getString(5) + "\t");
							System.out.println();
												
						}
					
						conn.close();
					}
					catch(Exception e)
					{
						System.err.println("Got an exceptional");
					}

					break;
			}
		}
		else
		{
			System.out.println("Login Failed");
		}
	}
	
	

}
