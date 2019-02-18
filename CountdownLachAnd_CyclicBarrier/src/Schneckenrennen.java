import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Schneckenrennen {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		   //CyclicBarrier startSync = new CyclicBarrier(4);
	        CountDownLatch wellnessSync = new CountDownLatch(4);
	        CountDownLatch start= new CountDownLatch(1);

	        new Schnecke(1, start, wellnessSync).start();
	        new Schnecke(2, start, wellnessSync).start();
	        new Schnecke(3, start, wellnessSync).start();
	        //Thread.sleep(1000); // die 4. Schnecke braucht immer am laengsten
	        new Schnecke(4, start, wellnessSync).start();
	        Thread.sleep(1000);
	        start.countDown();// start running
	        
	        new Thread(new Runnable(){
	           @Override
	           public void run()
	           {
	        	   try
	        	   {
	        	    wellnessSync.await();
	        	    System.out.println("Simulation ended!");
	        	   }catch(InterruptedException e)
	        	   {	        		   
	        	   }
	           }
	        }).start();
	       
           
	       
	        

	}

}
