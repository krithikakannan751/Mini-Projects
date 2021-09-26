/**
 * @(#)Login.java
 *
 *
 * @author 
 * @version 1.00 2018/12/16
 */

import java.util.TreeMap;
import java.io.Serializable;

public class Login implements Serializable 
{

	public static final int ADMINPASS = 1;
	public static final int PASS = 0;
	private TreeMap<String,Object[]> users;
    
    public Login() 
    {
    	users = new TreeMap<String, Object[]>();
    }
    
    public boolean addUser(String username, String password, boolean x)
    {
    	Object[] login = new Object[2];
    	login[ADMINPASS] = x;
    	login[PASS] = password;
    	if(users.containsKey(username))
    	{
    		return false;
    	}
    	else
    	{
    		users.put(username, login);
    	}
    	
    	return true;
    }
    
    public boolean removeUser(String username)
    {
    	return users.remove(username)!=null;
    }
    public boolean replaceUser(String initialUsername, String username, String password, boolean x)
    {
    	users.remove(initialUsername);
    	return addUser(username, password,x);
    }
    
    public Object[] getUsernames()
    {
    	return users.keySet().toArray();
    }
    
    public Object[] getUser(String username)
    {
    	return users.get(username);
    }
    
    public String toString(String username)
    {
    	return username + "		" + (String)users.get(username)[0] + "		" + (Boolean)users.get(username)[1];
    }
    
    public boolean checkUser(String username, String password)
    {
    	return users.containsKey(username)&&users.get(username)[PASS].equals(password);
    }
}