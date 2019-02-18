import java.util.Random;

public class Verbraucher implements Runnable {

	private Parkhaus parkhaus;


	public Verbraucher(Parkhaus parkhaus)
	{
		this.parkhaus = parkhaus;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{

			int kaufzeit = new Random().nextInt(1000);
			parkhaus.autoKaufen();
			Thread.sleep(kaufzeit);

			}catch(InterruptedException e)
			{}

		}
	}
}
