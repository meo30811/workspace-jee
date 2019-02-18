package vs_Uebung1;

public class Simulation {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Parkhaus parkhaus =new Parkhaus(10);

		for(int i=	1; i <=	20;	i++)	{
		new Auto("R-FH	" +	i,	parkhaus).start();
		}

		Thread.sleep(60000);
		System.out.println("Ende	der	Simulation!");

	}

}
