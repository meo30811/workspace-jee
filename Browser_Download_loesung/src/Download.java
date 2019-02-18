import javax.swing.JProgressBar;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Download extends Thread{

	// aktive Klasse

	    private final CountDownLatch start, stop;

		private JProgressBar balken;

	    // weitere Attribute zur Synchronisation hier definieren

		public Download( CountDownLatch start, CountDownLatch stop, JProgressBar balken /* ggf. weitere Objekte */) {
			this.balken = balken;
			this.start = start;
			this.stop = stop;
			this.balken = balken;
		    //start();
	    }


	    /*  hier die Methode definieren, die jeweils den Balken weiterschiebt
	     *  Mit balken.getMaximum() bekommt man den Wert fuer 100 % gefuellt
	     *  Mit balken.setValue(...) kann man den Balken einstellen (wieviel gefuellt) dargestellt wird
	     *  Setzen Sie den value jeweils und legen Sie die Methode dann für eine zufaellige Zeit schlafen
	     */
     @Override
     public void run() {
	int timePerKb = new Random().nextInt(500);
	System.out.println(Thread.currentThread().getName() + " run");
	try {
		start.await();
		System.out.println(Thread.currentThread().getName() + " start nach await");
		for(int i=0; i<=balken.getMaximum(); i++) {
			TimeUnit.MILLISECONDS.sleep(timePerKb);
			balken.setValue(i);
		}
		stop.countDown();
	} catch (InterruptedException e) {
	}
}



}
