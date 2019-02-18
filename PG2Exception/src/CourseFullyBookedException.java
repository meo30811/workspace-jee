
public class CourseFullyBookedException extends Exception {

	private int aktuelleAnzahlVonTeilnehmern;

	public CourseFullyBookedException(int aktuelleAnzahlVonTeilnehmern) {
		super();
		this.aktuelleAnzahlVonTeilnehmern = aktuelleAnzahlVonTeilnehmern;
	}

	public int getAktuelleAnzahlVonTeilnehmern() {
		return aktuelleAnzahlVonTeilnehmern;
	}

	public void setAktuelleAnzahlVonTeilnehmern(int aktuelleAnzahlVonTeilnehmern) {
		this.aktuelleAnzahlVonTeilnehmern = aktuelleAnzahlVonTeilnehmern;
	}
}
