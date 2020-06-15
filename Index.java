import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Index implements ActionListener 
{
	JFrame mainpage;//the actual window
	JPanel panel,panel2, panel3;//panels 
	JLabel email,password;// Label to display email on the gui
	JTextField emailid, lowerpaneltext;//the input fields
	JPasswordField passwordinp;//password input
	JButton proceed;//The button

	public void actionPerformed(ActionEvent ae)
	{
		String getemailid=emailid.getText();
		String getpassword=passwordinp.getText();
		//System.out.println("EmailId Main Page"+getemailid);
		Checker icobj=new Checker();
		icobj.check(getemailid,passwordinp.getText() );
		/*else if(retval=='0')//return value is 0 i.e. malicious query found
			JOptionPane.showMessageDialog(mainpage,"Malicious Query Found","SQL Injection", JOptionPane.WARNING_MESSAGE);*/
	}
	Index()// Default Constructor
	{
		mainpage=new JFrame("Database Activity Monitoring System");
		panel=new JPanel(new GridLayout(1,2));
		panel2=new JPanel(new FlowLayout());

		email=new JLabel("Email:");
		emailid=new JTextField();
		password=new JLabel("Password");
		passwordinp=new JPasswordField();

		proceed=new JButton("Proceed");
			proceed.addActionListener(this);

		panel.add(email);
		panel.add(emailid);
		panel.add(password);
		panel.add(passwordinp);
		panel.setPreferredSize(new Dimension(350, 25));//width height
		panel2.setBackground(Color.blue);
		panel2.add(proceed);

		mainpage.add(panel);
		mainpage.add(panel2);
		//mainpage.add(panel3);
		mainpage.setSize(1366,768);
		mainpage.setVisible(true);
		mainpage.getContentPane().setBackground(Color.blue);
		mainpage.setLayout(new FlowLayout());
		mainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new Index();
	}
}