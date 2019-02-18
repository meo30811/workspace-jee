
public class Person {

/*------------- EXIGENCE DU SYSTEM---------------
	 regle: l age des Personnes doivent etre plus grand ou egal a un  (alter>=1) sinon
	 une exception . 
------------- EXIGENCE DU SYSTEM---------------*/
private String name;
private String vorname;
private int alter;

public void setName(String name)
{
	this.name = name;
}
public String getName()
{
	return this.name;
}
public void setVorname(String vorname)
{
	this.vorname = vorname;
}
public String getVorname()
{
	return this.vorname;
}
public int getAlter()
{
	return this.alter;
}
public void setAlter(int alter) throws AgeNotAllowedException
{
	if(alter >= 1)
	{
		this.alter = alter;
	}
	else
	{
	AgeNotAllowedException e= new AgeNotAllowedException();
	e.setAgeNotAllowedException(alter);
	throw e;
	}
	
}





	
	
	

	
}
