import java.util.concurrent.atomic.AtomicInteger;

public class erstThread extends Thread {

    private int maxCount = 5000;
	//AtomicInteger count = new AtomicInteger(1);
	private static int count = 0;
	@Override
    public void run()
	{

		/*while(count<= maxCount)
		{
			synchronized(this)
			{
		       System.out.println(Thread.currentThread().getName()+": "+ count++);

			}
		}*/

		for(; count<= maxCount;)
		{
			synchronized(this)
			{
		       System.out.println(Thread.currentThread().getName()+": "+ ++count);

			}
		}
	}


}
