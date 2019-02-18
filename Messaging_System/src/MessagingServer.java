import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;

public class MessagingServer{

	private int portNummer= 1213;
	private ServerSocket  ss= null;
	private Socket client= null;
	
	public MessagingServer()
	{
		try {
			this.ss = new ServerSocket(portNummer);
			System.out.println("Server waiting for connection...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runServer()
	{
		ExecutorService service = Executors.newFixedThreadPool(20);
		MessageDatenbank db = new MessageDatenbank();
		while(true)
		{
		try {
			client = ss.accept();
			System.out.println("Client connected!"+client.getInetAddress().getHostAddress());
			RequestHandler handler = new RequestHandler(client,db);
			service.submit(handler);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
	
	
}
