import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientSocket {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String ip ="127.0.0.1";
		int port= 9999;
		Socket s = new Socket(ip,port);
		String str="Olivier Messeumeni";
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
	    out.println(str);
		os.flush();

		//System.out.println("C: data received from server");
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));// get data from socket
		String nickname = br.readLine();

		System.out.println("C: Server data = "+ nickname);
	}

}
