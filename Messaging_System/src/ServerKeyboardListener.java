import java.net.*;
import java.io.*;
import java.util.*;

public class ServerKeyboardListener implements Runnable {

	private Socket client ;
	
	public ServerKeyboardListener(Socket client)
	{
		this.client = client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
		 OutputStream out = client.getOutputStream();
         PrintWriter writer = new PrintWriter(out);
        
		 writer.println("Welcome to OTH messaging service.");
         writer.println("You are sending from " + client.getRemoteSocketAddress().toString());
         writer.println("Commands allowed are:");
         writer.println("REG username");
         writer.println("SND #<to>#<text>");
         writer.println("RCV<username>");
         writer.println();
         writer.flush();
         
		}catch(IOException e)
		{
			
		}
	}

}
