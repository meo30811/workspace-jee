import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*;

public class ServerService implements Runnable {

	private Socket client= null;
	private InputStream in ;
	private OutputStream out;
	private BufferedReader reader;
	private PrintWriter writer;
	private  BufferedOutputStream dataOut;

	public ServerService(Socket client)
	{
		this.client = client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try
	{
	  in = client.getInputStream();
	  reader = new BufferedReader(new InputStreamReader(in));
      dataOut = new BufferedOutputStream(client.getOutputStream());

	  out= client.getOutputStream();
	  writer = new PrintWriter(out);


	  String input = reader.readLine();
	  StringTokenizer parse = new StringTokenizer(input);

	  String method = parse.nextToken().toUpperCase();

	  String htmlDatei = parse.nextToken().toLowerCase();
      System.out.println(method+"    "+htmlDatei);

      if(method.equals("GET"))
      {
      //File file = new File("./src"+htmlDatei);

      //byte[] toByteArray = Files.readAllBytes(file.toPath());
        List<String> zeilen = Files.readAllLines(Paths.get("./src"+htmlDatei));

		  writer.println("HTTP/1.1 200 OK");
		  writer.println("Content-Type : text/html");

		  int length =0;
		  for(String temp: zeilen )
		  {
			  length += temp.length();
		  }
		  System.out.println(length);
		  writer.println("Content-length: 180");
          writer.println();
        for(String temp: zeilen)
         {
        	writer.println(temp);
        	writer.flush();
        	 System.out.println(temp);
         }



		 // dataOut.write(toByteArray,0,(int) file.length());
		  //dataOut.flush();

	      System.out.println("Data successfully sent!");

      }

		}catch(IOException e){
			e.printStackTrace();
		}finally
	    {
			try
			{
			  writer.close();
			  client.close();
			  dataOut.close();
			}catch(IOException e){}
	    }
	}
	}


