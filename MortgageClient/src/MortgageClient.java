
import java.net.*;
import java.io.*;

public class MortgageClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostname="127.0.0.1";
		int portnumber =4444;
		OutputStream out;
		PrintWriter writer;
		BufferedReader br;
		BufferedReader in;
		Socket clientSocket;
		try
		{
			System.out.println("Client programm:\n");
          clientSocket = new Socket(hostname,portnumber) ;// connect to the server
          out = clientSocket.getOutputStream();
          writer = new PrintWriter(out,true);

          br = new BufferedReader(new InputStreamReader(System.in));
          in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

          writer.println("InitCalculation");
          System.out.println("C: Check if you can attend the seminar or not:");
          System.out.println("C: give your Name here:");

          writer.println(br.readLine());

          System.out.println("S: "+in.readLine());

		}catch(UnknownHostException e)
		{
			System.exit(1);
		}catch(Exception e)
		{
			System.exit(1);
		}
	}

}
