
import java.net.*;
import java.io.*;

public class MortgageRunnable implements Runnable {

	Socket SocketClient= null;
	Mortgage m;

	public MortgageRunnable(Socket SocketClient)
	{
		this.SocketClient = SocketClient;
	}

	public void run() {

		try
		{
			OutputStream out = SocketClient.getOutputStream();
			PrintWriter writer= new PrintWriter(out,true);

			BufferedReader br = new BufferedReader(new InputStreamReader(SocketClient.getInputStream()));
            
			if(br.readLine().equalsIgnoreCase("Initcalculation"))
			{
				String name= br.readLine();
				m = new Mortgage();
				String result= m.checklist(name);
				writer.println(result);
			}
		  
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
