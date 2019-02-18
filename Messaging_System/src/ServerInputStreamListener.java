import java.io.*;

import java.net.*;

public class ServerInputStreamListener implements Runnable{

     private Socket client ;
	 private MessageDatenbank db;
	public ServerInputStreamListener(Socket client, MessageDatenbank db)
	{
		this.client = client;
		this.db= db;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String message= null;
			do
			{
				
			}while(message!= null && !(message = reader.readLine()).equalsIgnoreCase("BYE"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
