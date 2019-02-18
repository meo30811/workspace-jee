
public class Simulation {

	public static void main(String[] args ) throws InterruptedException
	{
		Parkhaus parkhaus=new Parkhaus(10);

		for(int i=	1;	i<=	20;	i++)	{
		  Thread t= new Thread(new Auto("R-FH" +	i,	parkhaus));
		  t.setName("R-FH" +	i);
		  t.setDaemon(true);
		  t.start();
		}

		Thread.sleep(30000);
		System.out.println("Ende der Simulation!");
	}
}
