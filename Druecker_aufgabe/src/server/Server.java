package server;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;
import java.io.*;

public class Server extends Thread {

	private Druecker d;
	private ExecutorService pool;
	private Socket client;
	ServerSocket ss ;
	public Server(int portnumber)
	{
		try {
			 ss = new ServerSocket(portnumber);
			System.out.println("Druecker server gestarted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run()
	{
		pool = Executors.newFixedThreadPool(10);
		d = new Druecker();
		while(true)
		{
			try {
				client = ss.accept();
				System.out.println("neue Verbindung!");
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter writer = new PrintWriter(client.getOutputStream());

				String filename = reader.readLine();
				pool.execute(new DrueckerAuftrag(filename,d));
                writer.println("file ist erfolgreich gedrückt! :-)");
                writer.flush();
                
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
