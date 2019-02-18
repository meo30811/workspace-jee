package Client;
import java.util.*;
import java.net.*;
import java.io.*;

public class InputStreamListener implements Runnable {

	private Socket client;

	public InputStreamListener(Socket client)
	{
		this.client = client;
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		  PrintWriter writer = null;
		try
        {
	     writer = new PrintWriter(client.getOutputStream(),true);
         BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
	     String message = null;
        
	     do
	     {
	    	message = reader.readLine();// ist ein blockierender Aufruf
	    	System.out.println(message);

	     }while(message!=null && !message.equalsIgnoreCase("bye"));
	     client.close();
        }catch(IOException e)
        {
        	new IOException("you have closed the Socket");
		    writer.println(e.getLocalizedMessage());
		    writer.flush();
        }
	}

}
