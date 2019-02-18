
public class Parkhaus {

	private int counter = 10;
	
	
	public Parkhaus(int counter)
	{
		this.counter = counter;
	}
	public synchronized void ausfahren(Auto a)
	 {
		System.out.println("Ausfahrt: "+a.name);
		counter = counter +1;
		   
	 }
	 public synchronized void einfahren(Auto a)
	 {
		   while(counter>10)
		   {
			 try{
				 this.wait();
			  }catch(InterruptedException ex)
			 {
				  //System.out.println("keine freie Plätze");
			 }
		   }
		 System.out.println("Einfahrt:"+a.name);
		 counter--;
		 this.notifyAll();
		  
	 }
 

}
