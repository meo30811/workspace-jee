import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Socket s = new Socket("localhost",2222);

			String str = "peter Hummel";

			//---------------STREAM-----------------
			OutputStream out =s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//---------------STREAM-----------------

			writer.println(str);
			writer.flush();

			//String text = null;


			writer.close();
			br.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
