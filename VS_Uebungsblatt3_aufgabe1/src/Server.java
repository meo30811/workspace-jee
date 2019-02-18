
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte server port eingeben: ");
		int port = scan.nextInt();
		
	    ServerSocket ss = new ServerSocket(port);
	    System.out.println("Warte auf Verbindung...\n\n");
	    Socket client= ss.accept();
	    System.out.println("Neue Verbindungen von "+client.getLocalAddress());
        
	    InputStream in = client.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        
	    OutputStream out = client.getOutputStream();
	    PrintWriter writer = new PrintWriter(out);

	    String msgClient = reader.readLine();
	    // Nachricht von Client
	    System.out.println(msgClient);

	    writer.println("*"+msgClient+"*");
	    writer.flush();



	}

}
