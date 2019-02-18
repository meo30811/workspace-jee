package server;

import java.util.concurrent.TimeUnit;

public class Druecker {

	private Object Monitor = new Object();
	private boolean zugriff = false;

	public void druecken(String filename)
	{
		synchronized(Monitor)
		{
			while(zugriff == true)
			{
			   try {
				System.out.println("warte druecker ist busy!");
				Monitor.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		   System.out.println("Druecker bereit zu druecken!");
		   zugriff = true;
		   try
		   {
		   TimeUnit.SECONDS.sleep(3);
		   System.out.println("folgende File : "+filename+"wird gedrückt");
		   }catch(InterruptedException e){}
           zugriff = false;
		}
	}
}
