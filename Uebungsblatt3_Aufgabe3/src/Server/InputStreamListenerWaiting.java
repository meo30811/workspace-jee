package Server;

import java.net.*;
import java.io.*;
import java.util.concurrent.Callable;

public class InputStreamListenerWaiting implements Callable {

	private BufferedReader reader;

	public InputStreamListenerWaiting(BufferedReader reader)
	{
		this.reader = reader;
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
	  return reader.readLine();
	}

}
