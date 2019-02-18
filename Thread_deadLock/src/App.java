
public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       final Runner run = new Runner();

       Thread t1 = new Thread( new Runnable(){
    	  public void run()
    	  {
    		  try
    		  {
    		  run.firstThread();
    		  }catch(InterruptedException e)
    		  {}
    	  }
       });

       Thread t2 = new Thread(new Runnable(){
     	  public void run()
     	  {
     		  try
     		  {
     		  run.secondThread();
     		  }catch(InterruptedException e)
     		  {}
     	  }
        });

       t1.start();
       t2.start();
       t1.join();
       t2.join();


       run.finished();
	}

}
