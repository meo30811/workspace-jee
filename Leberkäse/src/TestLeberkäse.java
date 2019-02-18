
public class TestLeberkäse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      KitchenCounter theke = new KitchenCounter(4);
       new Waiter(theke,"kellner_1").start();
       new Waiter(theke,"kellner_2").start();

      for(int i=1;i<=8;i++)
      {
    	 new Student(theke,"student_"+i).start();
      }
	}

}
