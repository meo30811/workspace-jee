
public class Auto implements Runnable{
	
	public String name ;
	private Parkhaus h ;	
	public Auto(String name,Parkhaus park)
	{
		this.name = name;
		this.h = park;
	    run();
	}
	@Override
	public void run()
	{
		try
		{
		Thread.sleep(200);
		h.einfahren(this);
		Thread.sleep(200);
		h.ausfahren(this);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
   
}
