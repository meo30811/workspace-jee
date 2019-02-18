package server;
import java.util.*;
import java.util.concurrent.*;
public class DrueckerAuftrag implements Runnable {

	private Druecker d;
	private String filename;

	public DrueckerAuftrag(String filename, Druecker d)
	{
		this.d = d;
		this.filename = filename;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int dauer = new Random().nextInt(10);
		try
		{
			d.druecken(filename);
			TimeUnit.SECONDS.sleep(dauer);

		}catch(InterruptedException e){}
	}
}
