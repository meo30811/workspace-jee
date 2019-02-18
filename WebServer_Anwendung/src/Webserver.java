
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Webserver {

	private int portNumber= 8080;
	private ServerSocket ss = null;
	private Socket client= null;

	public Webserver()
	{
		try {
			this.ss = new ServerSocket(portNumber);
			System.out.println("Waiting for Connection...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void runServer()
	{
	ExecutorService service = Executors.newFixedThreadPool(20);
	while(true)
	{
		try {
			client = ss.accept();
			System.out.println("st client is connected!");
			ServerService run = new ServerService(client);
		    service.execute(run);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


}
