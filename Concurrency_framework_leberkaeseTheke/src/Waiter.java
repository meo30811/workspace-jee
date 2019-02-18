import java.util.Random;

public class Waiter implements Runnable {

	private KitchenCounter kitchen;
	private String name;

	public Waiter(String name ,KitchenCounter kitchen)
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
				int wartezeit= new Random().nextInt(200);
				kitchen.put();
				Thread.sleep(wartezeit);
			}catch(InterruptedException e)
			{}
		}
	}
}
