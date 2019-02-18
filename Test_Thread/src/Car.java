
public class Car extends Thread {

	public Car()
	{
		setDaemon(true);
	}
	public void run()
	{
		while(true)
		{
			new Counter().add();
			try{
				sleep(200);
			}catch( InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
