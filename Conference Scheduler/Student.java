/**
 * @(#)Student.java
 *
 *
 * @author 
 * @version 1.00 2018/12/15
 */
import java.io.Serializable;

public class Student implements Serializable, Comparable
{
	String studentName;
	String parentName;
	String parentPhoneNumber;
	String parentEmail;
	int studentID;
	
    public Student() 
    {
    	studentName = "";
    	parentName = "";
    	parentPhoneNumber = "";
    	parentEmail = "";
    	studentID = 0;
    }
    
    public Student(int studentID)
    {
    	studentName = "";
    	parentName = "";
    	parentPhoneNumber = "";
    	parentEmail = "";
    	this.studentID = studentID;
    }
    
    public Student(String studentName, String parentName, String parentPhoneNumber, String parentEmail, int studentID)
    {
    	this.studentName = studentName;
    	this.parentName = parentName;
    	this.parentPhoneNumber = parentPhoneNumber;
    	this.parentEmail = parentEmail;
    	this.studentID = studentID;
    }
    
    public int getStudentID()
    {
    	return studentID;
    }
    
    public String getStudentName()
    {
    	return studentName;
    }
    
    public String getParentName()
    {
    	return parentName;
    }
    
    public String getParentPhoneNumber()
    {
    	return parentPhoneNumber;
    }
    
    public String getParentEmail()
    {
    	return parentEmail;
    }
    
    public void setStudentID(int studentID)
    {
    	this.studentID = studentID;
    }
    
    public void setStudentName(String studentName)
    {
    	this.studentName = studentName;
    }
    
    public void setParentName(String parentName)
    {
    	this.parentName = parentName;
    }
    
    public void setParentPhoneNumber(String parentPhoneNumber)
    {
    	this.parentPhoneNumber = parentPhoneNumber;
    }
    
    public void setParentEmail(String parentEmail)
    {
    	this.parentEmail = parentEmail;
    }
    
    public boolean equals(Object o)
    {
    	Student other = (Student)o;
    	return studentID == other.getStudentID();
    }
    
    public int compareTo(Object o)
    {
    	Student other = (Student)o;
    	return studentID - other.getStudentID();
    }
    
    public String toString()
    {
    	return studentID + "		" + studentName + "		" + "\n" 
    		+ parentName + "		" + parentEmail + "		" + parentPhoneNumber; 
    }
    
    public static int generateID(SchoolAttendance student)
    {
    	int genID = (int) (Math.random()*899999 + 100000);
    	boolean duplicate = false;
     	for(Object o : student.getStudentList()) 
     	{
     		Student other = (Student) o;
     		duplicate = (genID == other.getStudentID()); 
     		if(duplicate)
     		{
     			genID = generateID(student); 
     			break;
     		}
     	}
     	return genID;
    }
}