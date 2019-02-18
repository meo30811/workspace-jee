import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ExecutorService executor = Executors.newFixedThreadPool(20);
       Parkhaus parkhaus =new Parkhaus(10);

       for(int i=1; i<=20;i++)
       {
    	   executor.execute(new Auto("R-FH "+i,parkhaus));
       }




	}

}
