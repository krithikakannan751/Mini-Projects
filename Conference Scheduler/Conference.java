/**
 * @(#)Conference.java
 *
 *
 * @author 
 * @version 1.00 2018/12/16
 */

import java.io.Serializable;

public class Conference implements Serializable, Comparable
{

	Teacher teacher;
	Student student;
	String date;
	String description;
	
    public Conference()
    {
    	teacher = new Teacher();
    	student = new Student();
    	date = "";
    	description = "";
    }
    
    public Conference(Student student)
    {
    	teacher = new Teacher();
    	this.student = student;
    	date = "";
    	description = "";
    }
    
    public Conference(Teacher teacher, Student student, String date, String description)
    {
    	this.teacher = teacher;
    	this.student = student;
    	this.date = date;
    	this.description = description;
    }
    
    public Teacher getTeacherInfo()
    {
    	return teacher;
    }
    
    public Student getStudentInfo()
    {
    	return student;
    }
    
    public String getDate()
    {
    	return date;
    }
    
    public String getDescription()
    {
    	return description;
    }
    
    public void setTeacher(Teacher teacher)
    {
    	this.teacher = teacher;
    }
    
    public void setStudent(Student student)
    {
    	this.student = student;
    }
    
    public void setDate(String date)
    {
    	this.date = date;
    }
    
    public void setDescription(String description)
    {
    	this.description = description;
    }
    
    public int compareTo(Object o)
    {
    	Conference other = (Conference)o;
    	return other.compareTo(other.getStudentInfo()); 
    }
    
    public boolean equals(Object o)
    {
    	Conference other = (Conference)o;
    	return other.equals(other.getStudentInfo());
    }
    
    public String toString()
    {
    	return student.getStudentName() + "		" + teacher.getFullName() + "		" + date + "	 " + description;
    }
    
}