
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "abABdg2";
		CeasarCode code = new CeasarCode();

		try
		{
		   code.setCeasarCode(name);

	    }catch(illegalCapitalLetter e)
		{
	    	System.out.println("Capital letter not allowed...");
	    	e.printStackTrace();

		}catch(illegalCharacter e)
		{
			System.out.println("Character not allowed...");
			e.printStackTrace();
			System.out.println(e.getNotAllwedcharacter());
		}finally{
			System.out.println(code.getCeasarCode());
		}
	}

}
