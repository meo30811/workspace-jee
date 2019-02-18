
import java.net.*;
import java.io.*;

public class SocketServer {

	private int portnumber= 4444;
	private ServerSocket ss = null;

	public void runServer()
	{
		try
		{
			ss= new ServerSocket(portnumber);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		while(true)
		{
			try
			{
				Socket ClientSocket = ss.accept();
				MortgageRunnable m = new MortgageRunnable(ClientSocket);
				new Thread(m).start();
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
