
public class Runner extends Thread {

	public void run() {
		for(int i=0; i< 10;i++)
		{
			System.out.println("hello_second_Method "+i);
			
			try{
				sleep(100);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
				return;
			}
		}
	}

}
