import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Waiter extends Thread {
// aktive Klasse
	
	private KitchenCounter theke;
	public Waiter(KitchenCounter theke, String Name)
	{
		super(Name);
		this.theke = theke;
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			theke.put();
			System.out.println(currentThread().getName()+" neue Semmel abgelegt.");
			try{
				TimeUnit.SECONDS.sleep(new Random().nextInt(10));
			}catch(InterruptedException e)
			{

			}
		}
	}
}
