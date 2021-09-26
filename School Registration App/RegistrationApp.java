package parentSignup;

import java.util.LinkedList;
import java.io.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class RegistrationApp 
{

	public static void main(String[] args) 
	{
		
		 JOptionPane optionPane = new JOptionPane();
		 boolean done = false;
		 while(!done)
	       {
	      	String menu = "1 - Add Parent" + "\n"  + "2 - Look at Records " + "\n"+"3- Quit";
	      	String inputValue = JOptionPane.showInputDialog(menu);
	      		 int n = Integer.parseInt(inputValue);
		       switch(n)
		       {
		           case 1:  addParent();
		           		break;
		           case 2: lookAtRecords();
		           		break;
		           case 3:  done = true; 
		           		break;     
		       }
	       }
	}
	
	/**
	 * add parents onto the csv file
	 * @param no parameter for this method
	 */
	public static void addParent()
	{
		
	JTextField field1 = new JTextField();
	JTextField field2 = new JTextField();
	JTextField field3 = new JTextField();
	JTextField field4 = new JTextField();
	Object[] message = 
    {
    "Parent Name:", field1,
    "Student Name :", field2,
    "Phone Number :", field3,
    "Student's Stay:", field4,
     };
     
	int option = JOptionPane.showConfirmDialog(null, message, "Enter all information: ", JOptionPane.OK_CANCEL_OPTION);
	if (option == JOptionPane.OK_OPTION)
	{
	    String value1 = field1.getText();
	    String value2 = field2.getText();
	    String value3 = field3.getText();
	    String value4 = field4.getText();		
		    try
			{
		    	//save to file
		    	PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("C:\\Users\\Krithika Kannan\\Downloads\\Accounts.csv\\"),true));
				StringBuilder sb = new StringBuilder();
		        sb.append(value1 + ","+ value2 + "," + value3 + "," + value4 + "\n");
		        outFile.write(sb.toString());
		        outFile.close();
		        
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
	}
	else
		JOptionPane.showMessageDialog(null, "No Data");
	}
	
	/**
	 * prints out the csv file and the code, id, fee, and pin
	 * @param no parameters for this method
	 */
	public static void lookAtRecords()
	{
		List<Account> accounts = new LinkedList<Account>();
		String file = "C:\\Users\\Krithika Kannan\\Downloads\\Accounts.csv";
		List<String[]> newAccountHolder = parentSignup.CSV.read(file);
		for(String[] accountHolder : newAccountHolder)
		{
			String parentName = accountHolder[0];
			String studentName = accountHolder[1];
			String phoneNumber = accountHolder[2];
			String accountType= accountHolder[3];
			
			
			if(accountType.equals("FullDay"))
			{
				
				accounts.add(new HalfDay(parentName, studentName, phoneNumber));
			}
			
			else if(accountType.equals("HalfDay"))
			{
				
				accounts.add(new FullDay(parentName, studentName, phoneNumber));
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "ERROR READING ACCOUNT TYPE");
			}
		}
		for(Account acc : accounts)
		{ 
			System.out.println("\n************************");
			acc.showInfo();
		}
	}
}