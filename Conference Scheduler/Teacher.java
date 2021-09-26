/**
 * @(#)Teacher.java
 *
 *
 * @author 
 * @version 1.00 2018/12/15
 */
import java.io.Serializable;

public class Teacher implements Serializable, Comparable
{
	private String fullName;
	private String phoneNumber;
	private String schoolEmail;
	private String className;
	
    public Teacher() 
    {
    	fullName = "";
    	phoneNumber = "";
    	schoolEmail = "";
    	className = "";
    }
    
    public Teacher(String fullName)
    {
    	this.fullName = fullName;
    	this.phoneNumber = "";
    	this.schoolEmail = "";
    	this.className = "";
    }
    
    public Teacher(String fullName, String phoneNumber, String schoolEmail, String className)
    {
    	this.fullName = fullName;
    	this.phoneNumber = phoneNumber;
    	this.schoolEmail = schoolEmail;
    	this.className = className;
    }
    
    public String getFullName()
    {
    	return fullName;
    }
    
    public String getPhoneNumber()
    {
    	return phoneNumber;
    }
    
    public String getSchoolEmail()
    {
    	return schoolEmail;
    }
    
    public String getClassName()
    {
    	return className;
    }
    
    public void setFullName(String fullName)
    {
    	this.fullName = fullName;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
    	this.phoneNumber = phoneNumber;
    }
    
    public void setSchoolEmail(String schoolEmail)
    {
    	this.schoolEmail = schoolEmail;
    }
    
    public void setClassName(String className)
    {
    	this.className = className;
    }
    
    public String toString()
    {
    	return fullName + "		" + className + "		" + schoolEmail + "		" + phoneNumber;
    }
    
    public boolean equals(Object o)
    {
    	Teacher other = (Teacher)o;
    	return fullName.equals(other.getFullName());
    }
    
    public int compareTo(Object o)
    {
    	Teacher other = (Teacher)o;
    	return fullName.compareTo(other.getFullName());
    }
}