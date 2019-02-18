import java.util.ArrayList;
import java.util.List;

public class Mortgage {

   List<String> seminar = new ArrayList<String>();
   
   public Mortgage()
   {
	   this.seminar.add("Messeumeni");
	   this.seminar.add("Moumeni");
	   this.seminar.add("kemeni");
	   this.seminar.add("Tchakounte");
	   this.seminar.add("Tchasep");
	   this.seminar.add("Ngaleu");
   }
  public String checklist(String name)
  {
	 String  StrName="";
	 boolean getName = false ;
	 for(String tempName: seminar )
	 {
		 if(tempName.equalsIgnoreCase(name))
		 {
			 getName=true;
			 break;
		 }else
		 {
			 continue;
		 }
	 }
	 if(getName==true)
	 {
		 StrName=name+" is registered for the seminar";
	 }else
	 {
		 StrName=name+" is not registered for the seminar"; 
	 }
	 
	 return StrName;
  }
}
