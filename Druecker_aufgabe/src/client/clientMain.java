package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;

public class clientMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Socket client = new Socket("localhost",1213);
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter writer = new PrintWriter(client.getOutputStream());

		writer.println("text.xml");
		writer.flush();

		System.out.println(reader.readLine());
	}

}
