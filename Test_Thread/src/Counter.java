
public class Counter {

	private static int count = 0;
	
	Object monitor = new Object();
	
	public void add()
	{
		synchronized (monitor) {
			System.out.println(Thread.currentThread().getName()+":"+count);
			this.count++;
		}
	}
}
