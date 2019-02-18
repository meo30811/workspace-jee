import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			Socket s = new Socket("127.0.0.1",2157);

			//---------------STREAM-----------------
			OutputStream out =s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);

			InputStream in = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//---------------STREAM-----------------

			writer.println("hello world\n");
			writer.flush();

			//String text = null;


			writer.close();
			//br.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
