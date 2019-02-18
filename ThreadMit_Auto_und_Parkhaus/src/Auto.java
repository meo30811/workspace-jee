import java.util.Random;

public class Auto extends Thread {
// passive Klasse
	private String name;
	private Parkhaus parkhaus;

	public Auto(String name,Parkhaus parkhaus)
	{
		super(name);
		setDaemon(true);
		this.parkhaus = parkhaus;

	}

	@Override
	public void run() {

		Random zufallzahlgenerator = new Random();
		while(true)
		{
			try
			{
				Thread.sleep(zufallzahlgenerator.nextInt(1000));
				parkhaus.einfahren();
				Thread.sleep(zufallzahlgenerator.nextInt(1000));
				parkhaus.ausfahren();
			}catch(InterruptedException e)
			{}
		}
	}
}
