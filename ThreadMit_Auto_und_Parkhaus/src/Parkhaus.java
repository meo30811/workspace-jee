
public class Parkhaus {
// Aktive Klasse
	// methode: einfahren(), ausfahren()
	private int maxPlatzAnzahl;
	private int gate= 0;
	private Object Monitor = new Object();

	public Parkhaus(int maxPlatzAnzahl)
	{
		this.maxPlatzAnzahl= maxPlatzAnzahl;
	}

	public void einfahren()
	{
		synchronized(Monitor)
		{
		   while(gate== maxPlatzAnzahl)// viele Autos können warten
		   {
			   try
			   {
				   System.out.println("  Warte an Schranke: ");
				   Monitor.wait();
			   }catch(InterruptedException e){}
		   }
		   gate++;
		   System.out.println("Einfahrt: "+Thread.currentThread().getName());
		   Monitor.notifyAll();
		}
	}
	public void ausfahren()
	{
		synchronized(Monitor)
		{
			while(gate<2)
			{
				try
				{
					System.out.println(" Fahrt nicht aus warte: "+Thread.currentThread().getName());
					Monitor.wait();
				}catch(InterruptedException e){}
			}
			System.out.println("Ausfahrt: "+Thread.currentThread().getName());
			gate--;
			Monitor.notifyAll();
		}
	}


}
