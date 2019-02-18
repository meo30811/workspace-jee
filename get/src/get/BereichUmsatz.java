package get;

public class BereichUmsatz {
 public String bereich ;
 public double umsatz;
 
 public BereichUmsatz(String bereich,double umsatz)
 {
	 this.bereich = bereich ;
	 this.umsatz= umsatz;
 }
 
 public String getBereich() {
	return bereich;
}
 
public void setBereich(String bereich) {
	this.bereich = bereich;
}
public double getUmsatz() {
	return umsatz;
}
public void setUmsatz(double umsatz) {
	this.umsatz = umsatz;
}

 
}
