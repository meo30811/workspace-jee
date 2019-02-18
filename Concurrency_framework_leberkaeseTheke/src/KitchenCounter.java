import java.util.concurrent.locks.*;
public class KitchenCounter {

	private int anzahlLeber;
	private int counter = 0;
	private Lock monitor = new ReentrantLock();
	private Condition full = monitor.newCondition();
	private Condition empty = monitor.newCondition();

	public KitchenCounter(int anzahlLeber)
	{
		this.anzahlLeber = anzahlLeber;
	}

	public void take()
	{
		monitor.lock();

			while(counter== 0)
			{
				try
				{
				System.out.println("warte auf leberkaese: "+ Thread.currentThread().getName());
				empty.await();
				}catch(InterruptedException e){}
			}
			counter= counter -1;
			System.out.println(Thread.currentThread().getName()+" takes: "+"Leberkaese "+counter);
			full.signal();

		monitor.unlock();
	}
	public void put()
	{
		monitor.lock();
			while(counter==anzahlLeber)
			{
				try
				{
				 System.out.println("warting : "+ Thread.currentThread().getName());
				 full.await();
				}catch(InterruptedException e){}
			}
			counter = counter+1;
			System.out.println(Thread.currentThread().getName()+" puts: "+counter);
            empty.signal();

		monitor.unlock();
	}
}
