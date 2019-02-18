import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket {

	public static void main(String[] args) throws IOException, UnknownHostException{
		// TODO Auto-generated method stub

		    Scanner scan = new Scanner(System.in);

		    System.out.println("Bitte hostname und port eingeben:");
		    String hostname= scan.nextLine();
		    int port = scan.nextInt();

		    Socket client = new Socket(hostname,port);
		    //rfhpc987
		    InputStream in = client.getInputStream();
		    BufferedReader reader = new BufferedReader(new InputStreamReader(in));


		    OutputStream out = client.getOutputStream();
		    PrintWriter writer = new PrintWriter(out);

		    //BufferedReader msgReader = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Bitte geben Sie einen Text ein: ");
		    Scanner msgReader = new Scanner(System.in);
            
            
		    // Nachricht an server senden
		    String result= msgReader.nextLine();
		    writer.println(result);
		    writer.flush();

		    // die von Server gesendete Nachricht
		    String msgServer = reader.readLine();
		    // Nachricht von Client
		    System.out.println("Message von Server:"+msgServer);




	}

}
