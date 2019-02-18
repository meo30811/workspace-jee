
public class UnserTread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
	  for(int i= 0; i<10 ;i++)
	  {
		 System.out.println("hello_first_method "+i);
		 try{
			 Thread.sleep(100);
		 }catch(InterruptedException e)
		 {
			 e.printStackTrace();
		 }
	  }
	}


}

