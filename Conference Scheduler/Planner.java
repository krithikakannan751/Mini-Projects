/**
 * @(#)Planner.java
 *
 *
 * @author 
 * @version 1.00 2018/12/16
 */
import java.util.TreeSet;
import java.io.Serializable;

public class Planner implements Serializable
{
	TreeSet<Conference> conferenceList;
    
    public Planner() 
    {
    	conferenceList = new TreeSet<Conference>();
    }
    
    public boolean addConference(Conference conference)
    {
    	return conferenceList.add(conference);
    }
    
    public boolean removeConference(Conference conference)
    {
    	return conferenceList.remove(conference);
    }
    
    public boolean replaceConference(Conference initial, Conference replace)
    {
    	if(!(conferenceList.remove(initial)))
    	{
    		return conferenceList.remove(initial);
    	}
    	
    	return conferenceList.add(replace);
    }
    
    public Object[] getConferenceList()
    {
    	return conferenceList.toArray();
    }
    
    public int indexOf(Conference conference)
    {
    	Object[] conferences = conferenceList.toArray();
    	int index = -1;
    	for(int i =0; i<conferences.length; i++)
    	{
    		if(conference.equals(conferences[i]))
    		{
    			index = i;
    		}
    	}
    	
    	return index;
    }
    
    public String toString()
    {
    	String string = "Conferences: \n" + "Student Name:		Teacher Name:		Date:		Description:" + "\n";
    	for(int i =0; i<conferenceList.size(); i++)
    	{
    		string = string + conferenceList.toArray()[i].toString() + "\n";
    	}
    	
    	return string;
    }
    
    
}