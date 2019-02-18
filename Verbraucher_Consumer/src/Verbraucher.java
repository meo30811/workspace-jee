import java.util.Random;

public class Verbraucher extends Thread{

	private Parkhaus parkhaus;
	private Auto auto;

	public Verbraucher(Parkhaus parkhaus)
	{
		this.parkhaus= parkhaus;
		this.auto= auto;
	}
	public void run()
	{
		Random wartezeit = new Random();
		int kaufzeit = wartezeit.nextInt(1000);

		while(true)
		{
			try
			{
				parkhaus.autoKaufen();
				Thread.sleep(kaufzeit);

			}catch(InterruptedException e)
			{}
		}
	}

}
