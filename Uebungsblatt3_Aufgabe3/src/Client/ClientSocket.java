package Client;
import java.util.*;
import java.net.*;
import java.io.*;

public class ClientSocket implements Runnable {

	private Socket client ;

	public ClientSocket(Socket client)
	{
		this.client = client;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
     new Thread(new InputStreamListener(client)).start();
     new Thread(new KeyBoardListener(client)).start();   
	}

}
