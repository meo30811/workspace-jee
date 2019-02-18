
public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		KitchenCounter theke= new KitchenCounter(4);
		Thread t1= new Thread(new Waiter("kellner-1",theke));
		t1.setName("kellner-1");
		t1.start();
		Thread t2= new Thread(new Waiter("kellner-2",theke));
		t2.setName("kellner-2");
		t2.start();

		for(int i=1;i<=8;i++)
		{
			Thread t =new Thread(new Student("Student-"+i,theke));
			t.setName("Student-"+i);
			t.start();
		}

		Thread.sleep(3000);


	}

}
