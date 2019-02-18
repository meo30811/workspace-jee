import java.util.concurrent.locks.*;

public class Parkhaus {

	private int maxParkplatz;
	private int count=0;

	private Lock lock ;
	private Condition voll;
	private Condition leer;

	public Parkhaus(int maxParkplatz)
	{
		this.maxParkplatz = maxParkplatz;
		 lock = new ReentrantLock();
		 voll = lock.newCondition();
		 leer = lock.newCondition();
	}

	public void einfahren(String name)
	{
		lock.lock();
		Thread.currentThread().setName(name);
		while(count == maxParkplatz)
		{
			try
			{
				System.out.println("warte an Schranke: "+ Thread.currentThread().getName());
				voll.await();
			}catch(InterruptedException e){}
		}

		count++;
		System.out.println("Einfahrt: "+ Thread.currentThread().getName());
		lock.unlock();
	}
	public void ausfahren(String name)
	{
		lock.lock();
		Thread.currentThread().setName(name);
		count--;
		System.out.println("Ausfahrt: "+ Thread.currentThread().getName());
		voll.signal();
		lock.unlock();

	}


}
