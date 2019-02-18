
public class Teilnehmer {
	
	private static int letzteTeilnehmerNummer = 0;

	public Teilnehmer(String name) {
		super();
		this.name = name;
		this.nummer = ++letzteTeilnehmerNummer;
	}
	
	private String name;
	
	private int nummer;
	
	private String eMail;
	
	// Logik
	
	// Getter / Setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNummer() {
		return nummer;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	// toString
	

	@Override
	public String toString() {
		return "Teilnehmer [name=" + name + ", nummer=" + nummer + ", eMail=" + eMail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nummer;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teilnehmer other = (Teilnehmer) obj;
		if (nummer != other.nummer)
			return false;
		return true;
	}

}
