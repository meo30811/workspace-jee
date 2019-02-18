
public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parkhaus park = new Parkhaus(10);

		for(int i=1; i<=10;i++)
		{
			new Hersteller(park,new Auto("R-FH"+i)).start();
		}
		for(int i =1;i<=8;i++)
		{
			new Verbraucher(park).start();
		}

		try
		{
			Thread.sleep(3000);
		}catch(InterruptedException e){}
	}

}
