
public class CeasarCode {
	private String ceasarCode = "";

	public String getCeasarCode() {
		return ceasarCode;
	}

	public void setCeasarCode(String ceasarCode) throws illegalCapitalLetter, illegalCharacter {
		
		for(int i=0;i<ceasarCode.length();i++)
		{
			char c= ceasarCode.charAt(i);
			
			if (c >= 'a' && c <= 'z') {
				this.ceasarCode += c;
				continue;
			}
			
			// Ab hier ist ein Buchstabe auf jeden Fall invalide
			  if(ceasarCode.charAt(i)!=Character.toLowerCase(c))
			  {
				  illegalCapitalLetter e= new illegalCapitalLetter();
				  e.setIllegalChar(c);
				  throw e;
			  }
			/*illegalCharacter e= new illegalCharacter();
			e.setNotAllowedcharacter(c);
			  throw e;*/
		
		}
	}
}
