
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KitchenCounter {
// passive Klasse
	private int semmeln=0;
	private int kapazitaet;
	private Lock monitor = new ReentrantLock();
    private Condition voll;
    private Condition leer;

    public KitchenCounter(int kapazitaet)
    {
    	this.kapazitaet= kapazitaet;
    	this.voll = monitor.newCondition();
    	this.leer= monitor.newCondition();
    }

    public void put()
    {
    	monitor.lock();
    	while(semmeln==kapazitaet)
    	{
    		try
    		{
    			leer.await();
    		}catch(InterruptedException e)
    		{

    		}
    	}
    	semmeln++;
    	System.out.println("put(): noch " + semmeln + " Semmeln auf Theke");
    	voll.signal();
    	monitor.unlock();
    }
    public void take()
    {
    	monitor.lock();
    	while(semmeln==0)
    	{
    		try{
    			voll.await();
    		}catch(InterruptedException e)
    		{

    		}
    	}
    	semmeln--;
    	System.out.println("take(): noch " + semmeln + " Semmeln auf Theke");
    	leer.signal();// known as notify;
    	monitor.unlock();// give out the lock
    }
}
