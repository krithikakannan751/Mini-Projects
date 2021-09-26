/**
 * @(#)ConferenceApp.java
 *
 *
 * @author 
 * @version 1.00 2018/12/16
 */
import java.io.IOException;
import java.io.FileNotFoundException;
import javax.swing.*;

public class ConferenceApp 
{
	public static String userName;
	public static Staff teachers;
	public static Planner conferences;
	public static SchoolAttendance students;
	public static Login users;
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here
        startProgram();
    
		try
    	{
		userName = logIn();
		while(true) 
        {
        	int mainSelection = mainMenu();
        	switch(mainSelection) 
        	{
        		case 0: 
        		{	
        			studentMenu();
        			break;
        		}
        		
        	    case 1: 
        		{
        			teacherMenu();
        			break;
        		}
        		case 2: 
        		{
        			conferenceMenu();
        			break;
        		}		
        		case 3: 
        		{
        			int settingSelection = settingsMenu();
        			switch(settingSelection)
        			{
        				case 0: 
        					userMenu();
        					break;
        			}
        			break;
        		}
        		 
        		case 4: 
        		{
        			endProgram();
        			break;
        		}
        	}
        }
	
    }
        
    catch(Exception e)
    {
    	generalErrorMessage();
    	endProgram();
    }  
    }
    
    public static void generalErrorMessage()
    {
    	JOptionPane.showMessageDialog(null, "An error has occurred");
    	return;
    }
    
    public static void startProgram()
	{
    	try
    	{
    		teachers = Files.readTeachers();
    		conferences = Files.readConference();
    		students = Files.readStudents();
    		users = Files.readUsers();
    	}
    	catch(Exception e)
    	{
    	JOptionPane.showMessageDialog(null, "First run, files created. Default username/pass\nadmin/admin");

   			
    	teachers = new Staff();
    	conferences = new Planner();
    	students = new SchoolAttendance();
    	users = new Login();
    	users.addUser("admin", "admin", true);
    	try{
		
						Files.writeTeachers(teachers);
						Files.writeStudents(students);
						Files.writeConference(conferences);
						Files.writeUsers(users);
						}
						catch(Exception f)
						{
						JOptionPane.showMessageDialog(null, "error ocurred");
						}
    		endProgram();
    	}
	}
	
	public static void endProgram()
	{
		JOptionPane.showMessageDialog(null, "Program will quit");
    	try
    	{
			Files.writeTeachers(teachers);
			Files.writeStudents(students);
			Files.writeConference(conferences);
			Files.writeUsers(users);
    	}
    	catch(Exception e)
		{
			generalErrorMessage();
		}
    	System.exit(0);
	}
	
	public static void userMenu() 
    {
		
    	if(!(Boolean) users.getUser(userName)[Login.ADMINPASS])
    	{
    		JOptionPane.showMessageDialog(null, "Must be admin account");
    		return;
    	}
    	Object[] userOptions = {"Edit Existing User",
                    "Add User"};
		int userSelection = JOptionPane.showOptionDialog(null,
   			    	  "Please select an operation",
   				      "ConferenceApp",
    				  JOptionPane.YES_NO_CANCEL_OPTION,
   				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      userOptions,
				      userOptions[0]);
		switch(userSelection)
		{
			case 0: 
    			Object[] sortOptions = users.getUsernames();
				String s = (String)JOptionPane.showInputDialog(
        			null,
                    "Select user to edit:"	, 
                   	"ConferenceApp",
                    JOptionPane.PLAIN_MESSAGE,
                    null,						
                   	sortOptions,
                    "");
				userEditAddMenu(s); 
				break;
			case 1:
				userEditAddMenu("");
				break;
		}
    	
    }
    
    public static void userEditAddMenu(String s)
    {
    	String oldS = new String(s); 
    	JTextField username = new JTextField();
		JTextField password = new JTextField();
		JTextField admin = new JTextField();
    	
    	if(!s.equals(""))
    	{
    	 	username = new JTextField(s);
			password = new JTextField((String) users.getUser(s)[Login.PASS]);
	 		admin = new JTextField(((Boolean) users.getUser(s)[Login.ADMINPASS]).toString());
    	}
   
		Object[] message = 
    	{
    		"Changes:\nUsername(User removed if blank):", username,
    		"Password:", password,
    		"Admin Priviledge(should be true or false):", admin 
    	};
     
		int option = JOptionPane.showConfirmDialog(null, message, "ConferenceApp", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
    		if(!username.getText().equals(""))
    		{
    			boolean changed = users.replaceUser(oldS, username.getText(), password.getText(), Boolean.parseBoolean(admin.getText()));
    			if(!changed)
    				users.addUser(username.getText(), password.getText(), Boolean.parseBoolean(admin.getText()));
    		}
    		else
    		{ 	
    			users.removeUser(oldS);
    			return;
    		}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Select okay to save");
			userEditAddMenu(s); 
		}  
    }
    
    public static int settingsMenu()
    {
    	Object[] settingsOptions = {"Users",
                    "Program Info"};
		return JOptionPane.showOptionDialog(null,
   			    	  "Select an operation:",
   				      "ConferenceApp",
    				  JOptionPane.YES_NO_CANCEL_OPTION,
   				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      settingsOptions,
				      settingsOptions[0]);
    }
    
    public static void conferenceMenu()
    {
    	Object[] conferenceOptions = {"View Existing Conferences",
                    "Add Conference", "Search Conference"};
		int invoiceSelection = JOptionPane.showOptionDialog(null,
   			    	  "Please select an operation",
   				      "ConferenceApp",
    				  JOptionPane.YES_NO_CANCEL_OPTION,
   				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      conferenceOptions,
				      conferenceOptions[0]);
		switch(invoiceSelection)
		{
			case 0:
				JOptionPane.showMessageDialog(null, conferences.toString()); //shows everything 
				break;
			case 1: 
				conferenceEditAddMenu(new Conference());
				break;
			case 2: 
				int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Input ID number to find Conference:"));
				int ind = conferences.indexOf(new Conference(new Student(i)));
				if(ind == -1)
				{
					JOptionPane.showMessageDialog(null, "Conference not found");
					break;
				}
				else
				{
					conferenceEditAddMenu((Conference) conferences.getConferenceList()[ind]);
					break;
				}
		}
			
    }
    
    public static void conferenceEditAddMenu(Conference i)
    {
    	Conference oldI = new Conference(i.getTeacherInfo(), i.getStudentInfo(), i.getDate(), i.getDescription());
    	JTextField teacher = new JTextField(i.getTeacherInfo().getFullName());
    	JTextField student = new JTextField(i.getStudentInfo().getStudentID());
		JTextField date = new JTextField(i.getDate());
		JTextField description = new JTextField(i.getDescription());
	
		Object[] message = 
    	{
    		"Please input Info:\n Student ID Number:", student, 
    		"Teacher name:", teacher,
    		"Date:", date,
    		"Description:" + description
    	};
     
		int option = JOptionPane.showConfirmDialog(null, message, "ConferenceApp", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
			if(student.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Conference removed");
				conferences.removeConference(oldI);
				return;
			}
			else
			{
				int studentInd = students.indexOf(new Student(Integer.parseInt(student.getText())));
				int teacherInd = teachers.indexOf(new Teacher(teacher.getText()));
				if(studentInd != -1 && teacherInd != -1)
				{
					i.setStudent((Student) (students.getStudentList()[studentInd]));
					i.setTeacher((Teacher)(teachers.getTeacherList()[teacherInd]));
    				i.setDate(date.getText());
    				i.setDescription(description.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to create conference");
					return;
				}
			}
    		boolean changed = conferences.addConference(i);
    		if(!changed)
    			conferences.replaceConference(oldI, i);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Select okay to save");
			conferenceEditAddMenu(oldI); 
		}
    }
    
    public static void teacherMenu()
    {
    	Object[] teacherOptions = {"View Existing teacher Info",
                    "Add Teacher", "Search Teacher"};
		int teacherSelection = JOptionPane.showOptionDialog(null,
   			    	  "Select an operation",
   				      "ConferenceApp",
    				  JOptionPane.YES_NO_CANCEL_OPTION,
   				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      teacherOptions,
				      teacherOptions[0]);
		switch(teacherSelection)
		{
			case 0: 
				JOptionPane.showMessageDialog(null, teachers.toString());
				break;
			case 1: 
				teacherEditAddMenu(new Teacher());
				break;
			case 2: 
			    String i = JOptionPane.showInputDialog(null, "Input Teacher name");
				int ind = teachers.indexOf(new Teacher(i));
				if(ind == -1)
				{
					JOptionPane.showMessageDialog(null, "Teacher not found");
					break;
				}
				else
				{
					teacherEditAddMenu((Teacher) teachers.getTeacherList()[teachers.indexOf(new Teacher(i))]);
					break;
				}
				
		}
    	
    }
    
   
    public static void teacherEditAddMenu(Teacher i)
    {
    	Teacher oldI = new Teacher(i.getFullName(), i.getPhoneNumber(), i.getSchoolEmail(), i.getClassName());
    	JTextField name = new JTextField(i.getFullName());
    	JTextField email = new JTextField(i.getSchoolEmail());
		JTextField phone = new JTextField(i.getPhoneNumber());
		JTextField classroom = new JTextField(i.getClassName());
	
		Object[] message = 
    	{
    		"Please input Info:\nName:", name,
    		"Email:", email,
    		"Phone:", phone,
    		"Classroom:", classroom
    	};
     
		int option = JOptionPane.showConfirmDialog(null, message, "ConferenceApp", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
			if(name.getText().equals(""))
			{
				if(teachers.removeTeacher(oldI))
					JOptionPane.showMessageDialog(null, "Teacher removed");
				else JOptionPane.showMessageDialog(null, "Problem");
				return;
			}
			else
			{
				i.setFullName(name.getText());
				i.setSchoolEmail(email.getText());
				i.setPhoneNumber(phone.getText());
				i.setClassName(classroom.getText());
			}
		boolean changed = teachers.addTeacher(i);
    		if(!changed)
    			teachers.replaceTeacher(oldI, i);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Select okay to save");
			teacherEditAddMenu(oldI); 
		}
    }
    
    public static void studentMenu()
    {
    	Object[] studentOptions = {"View Existing Students",
                    "Add Students", "Search Students"};
		int studentSelection = JOptionPane.showOptionDialog(null,
   			    	 "Select an operation:",
   				      "ConferenceApp",
    				  JOptionPane.YES_NO_CANCEL_OPTION,
   				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      studentOptions,
				      studentOptions[0]);
		switch(studentSelection)
		{
			case 0: 
				JOptionPane.showMessageDialog(null, students.toString()); 
				break;
			case 1: 
				studentEditAddMenu(new Student());
				break;
			case 2: 
				int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Input ID number:"));
				int ind = students.indexOf(new Student(i));
				if(ind == -1)
				{
					JOptionPane.showMessageDialog(null, "Student not found");
					break;
				}
				else
				{
					studentEditAddMenu((Student) students.getStudentList()[ind]);
					break;
				}
		}
    	
    }
    
    
    public static void studentEditAddMenu(Student i)
    {
    	Student oldI = new Student(i.getStudentName(), i.getParentName(), i.getParentPhoneNumber(), i.getParentEmail(), i.getStudentID());
    	if(i.getStudentID() == 0)
    	i.setStudentID(Student.generateID(students));
    	JTextField name = new JTextField(i.getStudentName());
		JTextField parNam = new JTextField(i.getParentName());
		JTextField phone = new JTextField(i.getParentPhoneNumber());
		JTextField email = new JTextField(i.getParentEmail());
		
		Object[] message = 
    	{
    		"Please input Info:\nID Number: " + i.getStudentID() + 
    		"\nName:     ", name,
    		"Parent Name:     ", parNam,
    		"Phone:     ", phone,
    		"Email:     ", email
    	};
     
		int option = JOptionPane.showConfirmDialog(null, message, "ConferenceApp", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION)
		{
			if(name.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Student removed");
				students.removeStudent(oldI);
				return;
			}
			else
			{
				i.setStudentName(name.getText());
				i.setParentName(parNam.getText());
				i.setParentEmail(email.getText());
				i.setParentPhoneNumber(phone.getText());
    			boolean changed = students.addStudent(i);
    			if(!changed)
    				students.replaceStudent(oldI, i);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Select okay to save");
			studentEditAddMenu(oldI); 
		}
    }
    
    public static int mainMenu()
    {
    	Object[] mainOptions = {"Students",
                    "Teachers",
                    "Conferences",
                    "Settings",
                    "Quit"};
		return JOptionPane.showOptionDialog(null,
   			    	  "Select an operation",
   				      "ConferenceApp",
    				  JOptionPane.YES_NO_CANCEL_OPTION,
   				      JOptionPane.QUESTION_MESSAGE,
				      null,
				      mainOptions,
				      mainOptions[0]);
    }
   
    public static String logIn() 
	{
		JTextField username = new JTextField();
		JTextField password = new JTextField();		
		Object[] message = 
    	{
    		"Please log-in\nUsername:", username,
    		"Password:", password
    	};
     	do
     	{
			int option = JOptionPane.showConfirmDialog(null, message, "ConferenceApp", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION)
			{
				users.checkUser(username.getText(), password.getText());
			}
			else
			{
				endProgram();
			}
     	}while(!users.checkUser(username.getText(), password.getText()));
		return username.getText();
	}
    
}
