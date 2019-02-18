
public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		for(int i= 1; i<=10;i++)
		{
			new Car().start();
		}

		Thread.sleep(3000);

	}

}
