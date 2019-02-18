
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Thread t = new Thread(new UnserTread());
       Thread d = new Thread(new UnserTread());
       t.start(); // for parallel run.
       d.start();
	}

}
