import java.util.concurrent.locks.*;

public class Parkhaus {

	private int maxParkplatz;
	//private Object monitor = new Object();
	Lock schranke = new ReentrantLock();
	private Condition ein = schranke.newCondition();
	private Condition aus = schranke.newCondition();
	private int counter=0;

	public Parkhaus(int maxParkplatz)
	{
		this.maxParkplatz = maxParkplatz;
	}

	public void einfahren()
	{
		schranke.lock();
		try
		{
		 while(counter== maxParkplatz)
		  {
			System.out.println(" warte am Schranke: "+Thread.currentThread().getName());
			ein.await();
		 }

		counter++;
        System.out.println("Einfahrt: "+ Thread.currentThread().getName());
		aus.signal();
		}catch(InterruptedException e){}
		schranke.unlock();
	}
	public void ausfahren()
	{
		schranke.lock();
		try{
			while(counter<=2)
			{
			  System.out.println("warte bis drei auto in parkhaus: "+ Thread.currentThread().getName());
			  aus.await();
		    }
			counter--;
			System.out.println("Ausfahrt: "+ Thread.currentThread().getName());
			ein.signal();
		}catch(InterruptedException e){}

		schranke.unlock();
	}
}



