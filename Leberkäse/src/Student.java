import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {
// aktive Klasse

	private KitchenCounter theke;
	public Student(KitchenCounter theke, String Name)
	{
		super(Name);
		this.theke = theke;
	}

@Override
	public void run()
	{
		while(true)
		{
			theke.take();
			System.out.println(currentThread().getName()+" isst");

		try{
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		}catch(InterruptedException e)
		{

		}
	}
	}
}
