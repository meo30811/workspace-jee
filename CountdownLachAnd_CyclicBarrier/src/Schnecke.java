import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Schnecke extends Thread {

	 private int meineNr;
	    private CountDownLatch start;
	    private CountDownLatch wellness;

	    public Schnecke(int nr, CountDownLatch start, CountDownLatch wellness){
	        this.meineNr = nr; this.start = start; this.wellness = wellness;
	    }
	    @Override public void run() {

	        try {
	            System.out.println("Schnecke " + meineNr + " auf Startposition");
	            start.await(); // Blockierendes Warten auf "Startschuss"
	            System.out.println("Schnecke " + meineNr + " rennt los!");
	            Thread.sleep((long) new Random().nextInt(10000));
	            System.out.println("Schnecke " + meineNr + " am Ziel");

	            wellness.countDown();
	            //wellness.await(); // Blockierendes Warten, bis zwei Threds den countDown runtergezaehlt haben
	            System.out.println("Schnecke " + meineNr + " relaxt jetzt. Good Bye.");

	        } catch (InterruptedException e) {
	            // Fehler behandeln
	        }
	    }
}
