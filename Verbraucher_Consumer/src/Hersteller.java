import java.util.Random;

public class Hersteller extends Thread {

	private Parkhaus parkhaus;
	private Auto auto;

	public Hersteller(Parkhaus parkhaus,Auto auto)
	{
		this.parkhaus = parkhaus;
		this.auto = auto;
	}

	public void run()
	{
		Random wartezeit = new Random();
		int prodzeit = wartezeit.nextInt(1000);
		int kaufzeit = wartezeit.nextInt(1000);

		while(true)
		{
			try
			{
				parkhaus.autoHerstellen(auto);
				Thread.sleep(prodzeit);
			}catch(InterruptedException e)
			{}
		}
	}

}
