import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

	private int number;

	public MyCallable(int number)
	{
		this.number= number;
	}
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum= 0;
		for(int i= 1; i<=number; i++)
		{
			sum+=i;
		}

		Thread.sleep(100);
		return sum;
	}

}
