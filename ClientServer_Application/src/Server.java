import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try
      {
    	  System.out.println("S: server start");
		  ServerSocket ss = new ServerSocket(1236);
		  System.out.println("server started");

		  Socket client = ss.accept();
		  System.out.println("S: Client connected");
		  DataInputStream din = new DataInputStream(client.getInputStream());
		  DataOutputStream dout = new DataOutputStream(client.getOutputStream());

		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		  String msgin="", msgout="";
		  while(!msgin.equals("end"))
		  {
			  msgin= din.readUTF();// get message from client
			  System.out.println("C: "+msgin);
			  msgout= br.readLine();// answer the client
			  dout.writeUTF(msgout);
			  dout.flush();
		  }


      }catch(Exception e)
      {
    	 e.printStackTrace();
      }
	}

}
