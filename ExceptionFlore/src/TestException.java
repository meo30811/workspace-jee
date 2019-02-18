
public class TestException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p = new Person();
		p.setName("Messeumeni");
		p.setVorname("Olivier");

		try // POUR LES Exceptions
		{
			p.setAlter(0);// set ici parce que cette methode est programmer avec Exception
			System.out.println("the age is: "+p.getAlter());

		}catch( AgeNotAllowedException e)
		{
			System.out.println("this age is not allowed:"+ e.getAgeNotAllowedException());
			
		}

	}

}
