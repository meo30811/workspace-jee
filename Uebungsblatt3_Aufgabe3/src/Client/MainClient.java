package Client;

import java.net.*;
import java.io.*;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		try {
			
			Socket client = new Socket("localhost",1213);
			ClientSocket socket = new ClientSocket(client);
			new Thread(socket).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
