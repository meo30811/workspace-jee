import java.util.Random;

public class Auto implements Runnable {

	private Parkhaus parkhaus;
	private String name ;

	public Auto(String name, Parkhaus parkhaus)
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
				int rumfahrtzeit= new Random().nextInt(1000);
				int parkzeit = new Random().nextInt(1000);
				Thread.sleep(rumfahrtzeit);
				parkhaus.einfahren();
				Thread.sleep(parkzeit);
				parkhaus.ausfahren();
			}catch(InterruptedException e)
			{}
		}
	}
}
