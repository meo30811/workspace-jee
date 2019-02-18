import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class Parkhaus {

	private int maxStellplatz;
	private Deque<Auto> autos = new LinkedList<Auto>();
	private Lock monitor = new ReentrantLock();
	private Condition erzeuger = monitor.newCondition();
	private Condition kunde = monitor.newCondition();

	public Parkhaus(int maxStellplatz)
	{
		this.maxStellplatz= maxStellplatz;
	}

	public void autoErzeugen(Auto auto)
	{
		monitor.lock();

		try
		{
			while(autos.size()== maxStellplatz)
			{
				System.out.println("platz voll warte: "+ auto.getName());
				erzeuger.await();
			}
			autos.addLast(auto);
			System.out.println(Thread.currentThread().getName()+" erzeugt: "+auto.getName());
			kunde.signalAll();
		}catch(InterruptedException e)
		{}
		monitor.unlock();
	}
	public void autoKaufen()
	{
		monitor.lock();
		try
		{
			while(autos.size()== 0)
			{
				System.out.println(Thread.currentThread().getName()+" wartet");
				kunde.await();
			}
			System.out.println(Thread.currentThread().getName()+" kauft: "+autos.getFirst().getName());
			autos.pollFirst();
			erzeuger.signalAll();
		}catch(InterruptedException e){}

		monitor.unlock();
	}
}
