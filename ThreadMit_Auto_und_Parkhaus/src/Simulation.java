
public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parkhaus park = new Parkhaus(10);

		for(int i=1; i<=20;i++)
		{
		 new Auto("R-FH "+i,park).start();
		}
        try
        {
        	Thread.sleep(3000);
        	System.out.println("Ende der Simulation!");
        }catch(InterruptedException e){}

	}

}
