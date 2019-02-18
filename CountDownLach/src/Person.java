import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Person extends Thread {

    private String name;
    private CountDownLatch start;
   // private CyclicBarrier barrier;
    private CountDownLatch stop;

    public Person(String name, CountDownLatch start, CountDownLatch stop)
    {
    	super(name);
    	this.start = start;
    	this.stop = stop;
    }

    @Override
    public void run()
    {
    	try
    	{
        System.out.println(Thread.currentThread().getName()+" ist auf startposition");
    	start.await();
    	System.out.println(Thread.currentThread().getName()+" rennt los!");
    	Thread.sleep(new Random().nextInt(1000));
    	System.out.println(Thread.currentThread().getName()+" am Ziel");
    	stop.countDown();  	
    	System.out.println(Thread.currentThread().getName()+" relax now . Good bye.");
    	
    	} catch(InterruptedException e){}

    }

}
