import java.util.Random;

public class Erzeuger implements Runnable {

	private Parkhaus parkhaus;
	private int kennzeichen= 1;

	public Erzeuger(Parkhaus parkhaus)
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
			int prodzeit = new Random().nextInt(1000);
			int kaufzeit = new Random().nextInt(1000);
			Auto auto = new Auto("R-FH "+kennzeichen++);
			parkhaus.autoErzeugen(auto);
			Thread.sleep(prodzeit);

			}catch(InterruptedException e)
			{}

		}
	}
}
