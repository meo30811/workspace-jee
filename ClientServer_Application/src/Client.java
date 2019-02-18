import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try
		{
		   Socket s = new Socket("127.0.0.1",1236);

		   DataInputStream din = new DataInputStream(s.getInputStream());
		   DataOutputStream dout = new DataOutputStream(s.getOutputStream());

		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		   String msgin="",msgout="";
		   while(!msgin.equals("end"))
		   {
			   msgout= br.readLine();
			   dout.writeUTF(msgout);
			   msgin= din.readUTF();
			   System.out.println("S: "+msgin);
		   }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
