package Server;

import java.net.*;
import java.io.*;

public class ServerClass {

	private ServerSocket ss = null;
	private Socket client = null;
	
	public ServerClass()
	{
		try {
			ss= new ServerSocket(1213);
			System.out.println("server starts");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public void  runServer()
	{
		   try {
			client = ss.accept();
			System.out.println("Client connected!");
			new Thread(new MainServer(client)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
}
