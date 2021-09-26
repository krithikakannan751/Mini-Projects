/**
 * @(#)Staff.java
 *
 *
 * @author 
 * @version 1.00 2018/12/15
 */
import java.io.Serializable;
import java.util.TreeSet;

public class Staff implements Serializable
{
	private TreeSet<Teacher> teacherList;

    public Staff() 
    {
    	teacherList = new TreeSet<Teacher>();
    }
    
    public boolean addTeacher(Teacher teacher)
    {
    	return teacherList.add(teacher);
    }
    
    public boolean removeTeacher(Teacher teacher)
    {
    	return teacherList.remove(teacher);
    }
    
    public boolean replaceTeacher(Teacher initial, Teacher replace)
    {
    	if(!(teacherList.remove(initial)))
    	{
    		return teacherList.remove(initial);
    	}
    	
    	return teacherList.add(replace);
    }
    
    public Object[] getTeacherList()
    {
    	return teacherList.toArray();
    }
    
    public int indexOf(Teacher teacher)
    {
    	Object[] teachers = teacherList.toArray();
    	int index = -1;
    	for(int i = 0; i< teachers.length; i++)
    	{
    		if(teacher.equals(teachers[i]))
    		{
    			index = i;
    		}
    	}
    	return index;
    }
    
    public String toString()
    {
    	String string = "Teachers: \n" + "Name:		Classroom:		Email:		Phone:" + "\n";
    	for(Object o: teacherList.toArray())
    	{
    		Teacher other = (Teacher)o;
    		string = string + other.getFullName() + "		" + other.getClassName() + "		" + other.getSchoolEmail()
    			+ "		" + other.getPhoneNumber();
    	} 
    	
    	return string;
    }
    
}