package Client;
import java.util.*;
import java.net.*;
import java.io.*;

public class KeyBoardListener implements Runnable {

	private Socket client;

	public KeyBoardListener(Socket client)
	{
		this.client = client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintWriter writer= null;
		try
		{
			writer = new PrintWriter(client.getOutputStream(),true);

			Scanner clientMessage = new Scanner(System.in);

			String message = null;
			do
			{
				message= clientMessage.nextLine();
				writer.println(message);
				writer.flush();

			}while(message!= null && !message.equalsIgnoreCase("bye"));
          client.close();

		}catch(IOException e)
		{
			new IOException("you have closed the Socket");
		    writer.println(e.getMessage());
		    writer.flush();
		}
	}

}
