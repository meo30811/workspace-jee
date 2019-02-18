package vs_Uebung1;

import java.util.Random;

public class Auto extends Thread{

	// meine Aktive Klasse.

	private Parkhaus parkhaus ;
	
 public Auto(String name, Parkhaus p )
 {
	 super(name);
	 this.parkhaus = p;
	 setDaemon(true);// beendet das Programm, wenn der letzte Userthread beendet ist.
    
 }
 public void run() {
		// TODO Auto-generated method stub
		Random r = new Random();

		while(true)
		{
			int zufallzeit= r.nextInt(10);
			try
			{
				Thread.sleep(zufallzeit*1000L);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
				return;
			}
			parkhaus.einfahren();

			int parkzeit= r.nextInt(10);

			try
			{
				Thread.sleep(parkzeit*1000L);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			parkhaus.ausfahren();
		}

	}

}
