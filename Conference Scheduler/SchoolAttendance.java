/**
 * @(#)SchoolAttendance.java
 *
 *
 * @author 
 * @version 1.00 2018/12/16
 */
import java.util.TreeSet;
import java.io.Serializable;

public class SchoolAttendance implements Serializable
{
	TreeSet<Student> studentList;
	
    public SchoolAttendance() 
    {
    	studentList = new TreeSet<Student>();
    }
    
    public boolean addStudent(Student student)
    {
    	return studentList.add(student);
    }
    
    public boolean removeStudent(Student student)
    {
    	return studentList.remove(student);
    }
    
    public boolean replaceStudent(Student initial, Student replace)
    {
    	if(!(studentList.remove(initial)))
    	{
    		return studentList.remove(initial);
    	}
    	
    	return studentList.add(replace);
    }
    
    public Object[] getStudentList()
    {
    	return studentList.toArray();
    }
    
    public int indexOf(Student student)
    {
    	Object[] students = studentList.toArray();
    	int index = -1;
    	for(int i = 0; i<students.length; i++)
    	{
    		if(student.equals(students[i]))
    		{
    			index = i;
    		}
    	}
    	
    	return index;
    }
    
    public String toString()
    {
    	String string = "Student Info: \nParent Info: \n";
    	for(int i = 0; i< studentList.size(); i++)
    	{
    		Student student = (Student)studentList.toArray()[i];
    		string = string + student.getStudentID() + "		" + student.getStudentName() + "\n" 
    			+ student.getParentName() + "		" + student.getParentEmail() + "		" + student.getParentPhoneNumber();
    	}
    	
    	return string;
    }
}