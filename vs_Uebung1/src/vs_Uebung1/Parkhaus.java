package vs_Uebung1;

public class Parkhaus {
 private int count = 0;
 private int maxCount;
 private final Object Monitor = new Object();// verwendet fuer die Sicherheitsmechanismus

public Parkhaus(int maxCount)
{
	this.maxCount = maxCount;
}
public void einfahren()
{
	synchronized(Monitor){
	while(count >= maxCount)
	{
		try
		{
		   System.out.println("Warte an Schranke: "+Thread.currentThread().getName());
		   Monitor.wait();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	System.out.println("Einfahrt: "+Thread.currentThread().getName()+":"+count);
	this.count++;
	//hier ist KEIN notify() noetig,
    // da alle "schlafenden Threads" (= wartende Autos vor belegtem Parkhaus)
    // nicht geweckt werden müssen, wenn jemand einfaehrt
	}
}
public void ausfahren()
{
	synchronized(Monitor){
		this.count--;
		System.out.println("Ausfahrt: "+Thread.currentThread().getName());
		Monitor.notify();// ausfahrende Autos benachrichtigen unbedingt alle wartenden Autos.Denn ein Auto macht schließlich nur Platz fuer ein Anderes Auto
	}
  }
/**
 * @param arg0
 * @return
 * @see java.lang.Object#equals(java.lang.Object)
 */
public boolean equals(Object arg0) {
	return Monitor.equals(arg0);
}
/**
 * @return
 * @see java.lang.Object#hashCode()
 */
public int hashCode() {
	return Monitor.hashCode();
}
/**
 * @return
 * @see java.lang.Object#toString()
 */
public String toString() {
	return Monitor.toString();
}
}
