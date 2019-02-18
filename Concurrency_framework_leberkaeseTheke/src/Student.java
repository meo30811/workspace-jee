import java.util.Random;

public class Student implements Runnable {
	private KitchenCounter kitchen;
	private String name;

	public Student(String name ,KitchenCounter kitchen)
	{
		this.kitchen = kitchen;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true)
		{
			try
			{
				int wartezeit= new Random().nextInt(1000);
				kitchen.take();
				Thread.sleep(wartezeit);
			}catch(InterruptedException e)
			{}
		}
	}
}
