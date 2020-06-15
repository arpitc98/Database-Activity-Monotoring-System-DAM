import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class Checker 
{
	public void databaseConnectivity(String email, String password)
	{
		//new Admin();
		JFrame tempframe=new JFrame();
		try{
			Class.forName("com.mysql.jdbc.Driver");//importing the drivers
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Users","root","root");//create connection
			Statement stmt=con.createStatement(); 
			//System.out.printf("****") ;
			String query="Select * from user where email=\""+email+"\"";//username,password,
			//System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);

			if(rs!=null)
			{
				while(	rs.next()	)
				{
				//System.out.println("******");
					if(rs.getString(1).equals(email) && rs.getString(2).equals(password) && rs.getString(3).equals("admin"))
						new Admin();
					else if(rs.getString(1).equals(email) && rs.getString(2).equals(password)  )
						JOptionPane.showMessageDialog(tempframe,"Welcome "+email,"Welcome", JOptionPane.INFORMATION_MESSAGE);
					else 
						JOptionPane.showMessageDialog(tempframe,"Incorrect Credentials","Credentials!!", JOptionPane.WARNING_MESSAGE);
				}
			}
			else //if email id is wrong
				JOptionPane.showMessageDialog(tempframe,"Incorrect Credentials","Credentials!!", JOptionPane.WARNING_MESSAGE);
		}catch(Exception e){System.out.println(e); }

	}
	public void check(String email, String password)
	{
		int flag=0;
		try
		{
			Scanner sc=new Scanner(new File("C:\\Users\\arpit\\OneDrive\\Desktop\\SQL.txt")	);
			while(sc.hasNextLine())
			{
				String temp=sc.nextLine();
				if(temp.contains(email) || temp.equals(password))
					{
						flag=1;
						break;
					}
			}
			sc.close();
		}catch(FileNotFoundException e){System.out.println(e);}


		if(flag==1)
			JOptionPane.showMessageDialog(new JFrame(),"Malicious Query Found","SQL Injection", JOptionPane.WARNING_MESSAGE);
		this.databaseConnectivity(email,password);
	}
	public static void main(String args[])
	{
		new Checker();
	}
}