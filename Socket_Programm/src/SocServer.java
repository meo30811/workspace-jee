import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("S: Server is started");
		ServerSocket ss = new ServerSocket(9999);
		System.out.println("S: Server is waiting for client request");// lauscht blokierend
		Socket s = ss.accept();

		System.out.println("S: client connected");
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));// get data from socket
		String str = br.readLine();

		String nickname = str.substring(0,7);
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(nickname);
		out.flush();
		System.out.println("S: data sent from server to client");
	}

}
