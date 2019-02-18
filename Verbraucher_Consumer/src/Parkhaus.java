import java.util.Deque;
import java.util.LinkedList;

public class Parkhaus {

  private int maxStellplatz;
  private int countPlatz=0;
  private Object Monitor = new Object();
  private Deque<Auto> deque = new LinkedList<Auto>();

  public Parkhaus(int maxStellplatz)
  {
	  this.maxStellplatz = maxStellplatz;
  }

  public void autoHerstellen(Auto auto)
  {
	  synchronized(Monitor)
	  {
		  while(countPlatz== maxStellplatz)
		  {
			  try
			  {
				  System.out.println("warte parkplatz ist voll!! ");
				  Monitor.wait();
			  }catch(InterruptedException e)
			  {}
		  }
		  countPlatz++;
		  deque.addFirst(auto);
		  System.out.println("erzeugtes Auto: "+auto.getName());
		  Monitor.notifyAll();
	  }
  }
  public void autoKaufen()
  {
	  synchronized(Monitor)
	  {
		  while(countPlatz==0)
		  {
			  try
			  {
				  System.out.println(" warte bis Auto verfügbar ist");
				  Monitor.wait();
			  }catch(InterruptedException e)
			  {}
		  }
		  System.out.println("gekauftes Auto: "+deque.getLast().getName());
		  deque.pollLast();
		  countPlatz--;
		  Monitor.notifyAll();
	  }
  }
}
