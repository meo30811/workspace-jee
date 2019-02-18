package Server;

import java.io.Serializable;
import java.util.Calendar;

public class User implements Serializable {

	private String name;

	public User(String name)
	{
		this.name= name;
	}
	 public void setName(String name)
	 {
		 this.name = name;
	 }
	 public String getName()
	 {
		 return name;
	 }
	 @Override
	 public String toString()
	 {
		 return "OK "+this.name+" "+Calendar.getInstance().getTime();
	 }
}
