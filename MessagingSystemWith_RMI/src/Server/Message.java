package Server;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Message implements Serializable {

	public String text;
	public User user;
	public Date timeStamp;

	public Message(String text)
	{
		this.timeStamp = Calendar.getInstance().getTime();
		this.text = text;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getCommand()
	{
		String[] mail = text.split(" ");
		String result = mail[0];
		return result;
	}
	public String getUserFromText()
	{
		String[] result = text.split(" ");
		return result[1];
	}
    public String getSender()
    {
    	String[] mail = text.split(" ");
		String[] result = mail[1].split("#");
		return result[0];
    }
    public String getReceiver()
    {
        String[] mail = text.split(" ");
        String[] result = mail[1].split("#");
	    return result[1];
    }
    public String getMessageToSend()
    {
        int startindex= text.indexOf(' ');
        String result = text.substring(startindex, text.length());
        return result;
    }
    
    @Override
    public String toString()
    {
    	return "OK "+ this.getText()+"#"+getTimeStamp();
    }

}
