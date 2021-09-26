/**
 * @(#)File.java
 *
 *
 * @author 
 * @version 1.00 2018/12/16
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Files 
{
	public static final String STUDENT_FILE = "StudentInfo.txt";
	public static final String TEACHER_FILE = "TeacherInfo.txt";
	public static final String CONFERENCE_FILE = "ConferenceList.txt";
	public static final String USER_FILE = "Users.text";

	public static Staff readTeachers()throws Exception
	{
		FileInputStream inputFile = new FileInputStream(new File(TEACHER_FILE));
		ObjectInputStream inputObject = new ObjectInputStream(inputFile);
		return (Staff)inputObject.readObject();
	}
	
	public static SchoolAttendance readStudents()throws Exception
	{
		FileInputStream inputFile = new FileInputStream(new File(STUDENT_FILE));
		ObjectInputStream inputObject = new ObjectInputStream(inputFile);
		return (SchoolAttendance)inputObject.readObject();
	}
	
	public static Planner readConference()throws Exception
	{
		FileInputStream inputFile = new FileInputStream(new File(CONFERENCE_FILE));
		ObjectInputStream inputObject = new ObjectInputStream(inputFile);
		return (Planner)inputObject.readObject();
	}
	
	public static Login readUsers()throws Exception
	{
		FileInputStream inputFile = new FileInputStream(new File(USER_FILE));
		ObjectInputStream inputObject = new ObjectInputStream(inputFile);
		return (Login)inputObject.readObject();
	}
	
	public static void writeTeachers(Staff list) throws Exception
    {
		FileOutputStream outputFile = new FileOutputStream(new File(TEACHER_FILE));
		ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);
		outputObject.writeObject(list);
		outputFile.close();	
    }
    
    public static void writeStudents(SchoolAttendance list) throws Exception
    {
		FileOutputStream outputFile = new FileOutputStream(new File(STUDENT_FILE));
		ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);
		outputObject.writeObject(list);
		outputFile.close();	
    }
    
    public static void writeUsers(Login list) throws Exception
    {
		FileOutputStream outputFile = new FileOutputStream(new File(USER_FILE));
		ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);
		outputObject.writeObject(list);
		outputFile.close();	
    }
    
    public static void writeConference(Planner list) throws Exception
    {
		FileOutputStream outputFile = new FileOutputStream(new File(CONFERENCE_FILE));
		ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);
		outputObject.writeObject(list);
		outputFile.close();	
    }
	
	
	
    
}