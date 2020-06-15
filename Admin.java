import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Admin implements ActionListener
{
	JFrame adminfunc=new JFrame("Admin");
	JFrame maliciousframe=new JFrame("Malicious Records");
	JButton analyzerecords, updaterecords;
	JPanel toppanel,bottompanel;
	JLabel maloutput;

	void eventHandler(String malrecords)
	{//a method that takes the input as malrecord string if it is empty then Display popup else display all the malicious records
		//System.out.println("Eventhandler Called");
		if(malrecords==null )
			JOptionPane.showMessageDialog(adminfunc,"No Malicious Log Record found","Safe Logs", JOptionPane.WARNING_MESSAGE);
		else
		{
			maliciousframe.setVisible(true);
			maloutput.setText(malrecords);
			maliciousframe.add(maloutput);
			adminfunc.setVisible(false);
			maliciousframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 //breaking the malicious records on the basis of new line char added*/
		}
	}
	void analyzeRecords() 
	{
		maloutput=new JLabel();
		String templog,tempquery, malrecords=null;// all the malicious records found will be stored in this string
		int count=0;
		try
		{
			Scanner mquery=new Scanner(new File("C:\\Users\\arpit\\OneDrive\\Desktop\\SQL.txt")	);//malicious query file
			Scanner log=new Scanner(new File("C:/ProgramData/MySQL/MySQL Server 8.0/Data/ANONYMOUS2.txt") );//log file
			while(log.hasNextLine())
			{
				
				templog=log.nextLine();//reading the log line by line
				//System.out.println(templog );//success
				if(templog==null)
					eventHandler(malrecords);
				while(	mquery.hasNextLine() )
				{
					tempquery=mquery.nextLine();
					if(tempquery.contains("information_schema"))
					{
						//System.out.println("Query Found");
						malrecords += tempquery;//adding templog to the malicious records
						System.out.println(malrecords);
					}
				}
			}
			eventHandler(malrecords);
		}catch(Exception e){System.out.println(e);}
	}

	public void actionPerformed(ActionEvent ae)
	{
		this.analyzeRecords();
	}

	Admin()
	{
		toppanel=new JPanel();

		analyzerecords=new JButton("Analyse Records");
			analyzerecords.addActionListener(this);
			toppanel.add(analyzerecords);

		adminfunc.setVisible(true);
		adminfunc.add(toppanel);
		adminfunc.setSize(1366,768);
		adminfunc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new Admin();
	}
}
//Analyse records and update records,