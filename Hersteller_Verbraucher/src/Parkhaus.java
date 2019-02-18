import java.util.Deque;
import java.util.LinkedList;

public class Parkhaus {

	private int maxStellplatz;
	private Deque<Auto> autos = new LinkedList<Auto>();
	private final Object monitor = new Object();

	public Parkhaus(int maxStellplatz)
	{
		this.maxStellplatz = maxStellplatz;
	}

	public void autoErzeugen(Auto auto)
	{
		synchronized(monitor)
		{
			while(autos.size()== maxStellplatz)
			{
				try
				{
					System.out.println("Platz ist voll warte: "+ Thread.currentThread().getName());
					monitor.wait();

				}catch(InterruptedException e){}
			}

			autos.addLast(auto);
			System.out.println(Thread.currentThread().getName()+" erzeugt: "+ auto.getName());
			monitor.notify();
		}

	}
	public void autoKaufen()
	{
		synchronized(monitor)
		{
			while(autos.size()== 0)
			{
				try
				{
					System.out.println("käufer warte an Schranke: "+Thread.currentThread().getName());
					monitor.wait();

				}catch(InterruptedException e){}
			}

			System.out.println(Thread.currentThread().getName()+" kauft: "+ autos.getFirst().getName());
			autos.pollFirst();
			monitor.notify();
		}


	}


}
