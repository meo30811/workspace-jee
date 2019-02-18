import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Socket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss;
		try {
		 ss = new ServerSocket(2222);
			System.out.println("S: server gestartet");
			Socket client = ss.accept();
			System.out.println("S: Client ist verdunden");

			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String s = null;

			while((s = br.readLine())!= null)
			{
				System.out.println("S: Empfangen von Client: "+s);
			}
			writer.close();
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
