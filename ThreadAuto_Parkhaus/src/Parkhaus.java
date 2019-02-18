
public class Parkhaus {

	private int maxParkplatz;
	private Object monitor = new Object();
	private int counter=0;

	public Parkhaus(int maxParkplatz)
	{
		this.maxParkplatz = maxParkplatz;
	}

	public void einfahren()
	{
		synchronized(monitor)
		{
			while(counter== maxParkplatz)
			{
				try
				{
					System.out.println(" warte am Schranke: "+Thread.currentThread().getName());
					monitor.wait();
				}catch(InterruptedException e)
				{}
			}
			counter++;
			System.out.println("Einfahrt: "+ Thread.currentThread().getName());
			monitor.notify();
		}
	}
	public void ausfahren()
	{
		synchronized(monitor)
		{
			while(counter<=2)
			{
				try{
					System.out.println("warte bis drei auto in parkhaus: "+ Thread.currentThread().getName());
					monitor.wait();
				}catch(InterruptedException e){}
			}
			counter--;
			System.out.println("Ausfahrt: "+ Thread.currentThread().getName());
			monitor.notify();
		}
	}

}
