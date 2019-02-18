import java.util.Map;
import java.util.concurrent.locks.*;
import java.util.regex.Pattern;
import java.util.*;
import java.net.*;
import java.io.*;

public class MessageDatenbank {
// passive Klasse
	private Socket client;
	public Map<String,List<Message>> db = new TreeMap<>();
	private List<Message> messages;
    private Lock lock = new ReentrantLock();

	public boolean register(String username)
	{
		lock.lock();
		boolean ret= false;
		try
		{
			if(username!= null)
			{
              messages = new LinkedList<Message>();
		      db.put(username, messages);
		      ret = true;
			}else
			{}
		 return ret;
		}
		finally
		{
		   lock.unlock();
		}

	}
	public String senden(String receiver ,String message)
	{

		lock.lock();
		try
		{
		if(db.containsKey(receiver))
		{
			Message m = new Message(message);
			db.get(receiver).add(m);
		}
		return "OK "+message+"# "+Calendar.getInstance().getTime();
		}finally
		{
	   lock.unlock();
		}
	}
	public boolean receiverInDb(String receiver)
	{
		lock.lock();
		boolean ret = false;
		for(Map.Entry<String , List<Message>> entry: db.entrySet())
		{
			if(entry.getKey().equals(receiver))
			{
				ret = true;
			}
		}
	   lock.unlock();
		return ret;
	}
	public List<Message> abrufen(String username)
	{
		lock.lock();
		try
		{
		 List<Message> message= null;
		if(db.containsKey(username))
		{
		    message = db.get(username);
			return message;
		}
		return message;
		}finally
		{
		  lock.unlock();
		}

	}
}
