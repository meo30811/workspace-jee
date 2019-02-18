import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Kurs {

    private String name;
	
	private int maximaleTeilnehmerAnzahl;
	
	public Kurs(String name, int maximaleTeilnehmerAnzahl) {
		super();
		this.name = name;
		if (maximaleTeilnehmerAnzahl >= 0) {
			this.maximaleTeilnehmerAnzahl = maximaleTeilnehmerAnzahl;
		}
	}
	
	private HashSet<Teilnehmer> teilnehmer = new HashSet<Teilnehmer>();

	// Logik
	public void einschreiben(Teilnehmer neuerTeilnehmer) throws  CourseFullyBookedException, ParticipationNotAllowedException {
		// Pr�fe, ob �berhaupt ein neuer Teilnehmer �bergeben wurde
		
		// Pr�fe, ob die maximale Teilnehmerzahl bereits �berschritten
		if (teilnehmer.size() + 1 > maximaleTeilnehmerAnzahl ) {
			throw new CourseFullyBookedException(teilnehmer.size());
		}
		// Pr�fe, ob der ein A im Namen hat
		String name = neuerTeilnehmer.getName();
		if (name == null || name.toUpperCase().contains("A")) {
			ParticipationNotAllowedException ex = new ParticipationNotAllowedException();
			ex.setProblemFall(neuerTeilnehmer);
			throw ex;
		}
		// Endlich: Teilnehmer in Kurs aufnehmen
		teilnehmer.add(neuerTeilnehmer);
	}
	
	
	// Getter / Setter
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaximaleTeilnehmerAnzahl() {
		return maximaleTeilnehmerAnzahl;
	}

	public void setMaximaleTeilnehmerAnzahl(int maximaleTeilnehmerAnzahl) {
		this.maximaleTeilnehmerAnzahl = maximaleTeilnehmerAnzahl;
	}
}
