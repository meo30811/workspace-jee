import java.util.Random;

public class Auto implements Runnable {

	private String name;
	private Parkhaus parkhaus;

	public Auto(String name, Parkhaus parkhaus)
	{
		this.parkhaus = parkhaus;
		this.name= name;

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
        Random wartezeit= new Random();
		while(true)
		{
			try {
		  Thread.sleep(wartezeit.nextInt(1000));
		  parkhaus.einfahren(this.name);
		  Thread.sleep(wartezeit.nextInt(1000));
		  parkhaus.ausfahren(this.name);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

}
