import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
	  CountDownLatch start = new CountDownLatch(1);
      CountDownLatch stop = new CountDownLatch(4);

      new Person("Olivier",start,stop).start();
      new Person("Remy",start,stop).start();
      new Person("Armand",start,stop).start();
      new Person("Ghislain",start,stop).start();


      Thread.sleep(1000);

      start.countDown();//

      stop.await();



	}

}
