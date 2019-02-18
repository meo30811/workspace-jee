
public class Simulation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Parkhaus parkhaus = new Parkhaus(10);

		Thread hersteller = new Thread(new Erzeuger(parkhaus));
		hersteller.setName("Continental");
		//hersteller.setDaemon(true);
		hersteller.start();
		for(int i=1; i<=5;i++)
		{
			Thread verbraucher= new Thread(new Verbraucher(parkhaus));
            verbraucher.setName("Kunde_"+i);
			//verbraucher.setDaemon(true);
			verbraucher.start();

		}

		Thread.sleep(3000);

		System.out.println("Ende der Simulation");
	}


}
