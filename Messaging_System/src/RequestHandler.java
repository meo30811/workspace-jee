import java.net.*;
import java.util.List;
import java.io.*;

public class RequestHandler implements Runnable{

	private MessageDatenbank db ;
	private Socket client;
	private InputStream in ;
	private PrintWriter writer;
	private OutputStream out;
	private BufferedReader reader;

	public RequestHandler(Socket client,MessageDatenbank db)
	{
			this.client = client;
			this.db = db;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try
		{

			in = client.getInputStream();
			out= client.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(out);


			 writer.println("Welcome to OTH messaging service.");
             writer.println("You are sending from " + client.getRemoteSocketAddress().toString());
             writer.println("Commands allowed are:");
             writer.println("REG username");
             writer.println("SND #<to>#<text>");
             writer.println("RCV<username>");
             writer.println();
             writer.flush();

            String message= null;

	        do
	        {
	        	message = reader.readLine();

	    	    System.out.println(message);
				String command = getCommand(message).toLowerCase();
				System.out.println(command);

			switch(command)
			{
			case "snd":
				String sender = getSender(message);
				String receiver= getReceiver(message);
				System.out.println(sender+" "+receiver);

				String useMessage= db.senden(receiver,getMessageToSend(message));
	            writer.println(useMessage);
	            writer.flush();

				break;
			case "reg":
				String user = getUser(message);

				boolean ret= db.register(user);
				if(ret== true)
				{
				   System.out.println("OK_"+user);
				   writer.println("OK_"+user);
				   writer.flush();

				}

				break;
			case "rcv":
				String recv = getUser(message);
					List<Message> msgReceived= db.abrufen(recv);
					writer.println("OK "+msgReceived.size());
					//writer.flush();
					for(Message temp: msgReceived)
						writer.println("OK "+temp.getNachricht());
				        writer.flush();
				break;
			}
		}while(message!=null && !message.equalsIgnoreCase("bye"));
		}catch(IOException e){
			e.printStackTrace();
		}finally
		{
		}
    }
	public String getCommand(String message)
	{
		String[] mail = message.split(" ");
		String result = mail[0];
		return result;
	}
	public String getUser(String message)
	{
		String[] result = message.split(" ");
		return result[1];
	}
    public String getSender(String message)
    {
    	String[] mail = message.split(" ");
		String[] result = mail[1].split("#");
		return result[0];
    }
    public String getReceiver(String message)
    {
        String[] mail = message.split(" ");
        String[] result = mail[1].split("#");
	    return result[1];
    }
    public String getMessageToSend(String message)
    {
        int startindex= message.indexOf(' ');
        String result = message.substring(startindex, message.length());
        return result;
    }
}
