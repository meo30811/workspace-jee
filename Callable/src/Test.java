import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService service = Executors.newSingleThreadExecutor();

		Random random = new Random();
		MyCallable call = new MyCallable(random.nextInt(100));
		long sTime = System.currentTimeMillis();
		Future<Integer> future = service.submit(call);
		long totalTime=0;

		try {
			while(!future.isDone())
			{
				totalTime = System.currentTimeMillis()-sTime;
				if(totalTime> 1000)
				{
					 System.out.println(totalTime+":"+sTime+" future takes too long to execute cancel");
					 future.cancel(true);
				}
			}
			try
			{
			  System.out.println("future: "+future.get(2, TimeUnit.SECONDS)+" ended in:"+ totalTime+" millisecond");
			}catch (InterruptedException | ExecutionException e)
			{
				e.printStackTrace();
			}
		}catch( Exception e)
		{

    	   e.printStackTrace();
	  }finally
	  {
		  if(service!=null)
		  {
		  service.shutdown();
		  }
	  }


    }
}
