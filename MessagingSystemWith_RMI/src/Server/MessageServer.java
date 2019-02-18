package Server;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.*;

public class MessageServer implements MessagingIF {

	private Map<User, List<Message>> db = new TreeMap<>();
	private Lock lock = new ReentrantLock();
	List<Message> messages ;

	@Override
	public User registrieren(User user) throws RemoteException {
		// TODO Auto-generated method stub
		lock.lock();
		try
		{
		if(user!= null)
		{
			db.put(user,new LinkedList<Message>());
		}
		return user;
		}finally
		{
		lock.unlock();
		}
	}

	@Override
	public Message senden(User user,Message message) throws RemoteException {
		// TODO Auto-generated method stub
		lock.lock();
		try
		{
		if(db.containsKey(user))
		{
			db.get(user).add(message);
		}
		return message;
		}finally
		{
	   lock.unlock();
		}
	}

	@Override
	public List<Message> empfangen(User ich) throws RemoteException {
		// TODO Auto-generated method stub
		lock.lock();
		try
		{
		if(db.containsKey(ich))
		{
			 messages = db.get(ich);
		}
		return messages;
		}finally
		{
		lock.unlock();
		}
	}

}
