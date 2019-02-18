
public class Programm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Test");
		Teilnehmer t1 = new Teilnehmer("Peter");
		Teilnehmer t2 = new Teilnehmer("Anna");

		Kurs pg2 = new Kurs("Programmieren 2", 5);
		try {
			pg2.einschreiben(t1);
			pg2.einschreiben(t2);
		} catch (CourseFullyBookedException e) {
			System.out.println("Sie k�nnen sich leider mehr einschreiben. Der Kurs ist voll. Es sind schon " + e.getAktuelleAnzahlVonTeilnehmern() + " Teilnehmer im Kurs.");
		} catch (ParticipationNotAllowedException e) {
			// TODO Auto-generated catch block
			System.out.println("the name of the Participant not allowed:"+ e.getProblemFall().getName());
			e.printStackTrace();
		} finally {
			System.out.println("Danke f�r Ihre Anmeldung");
		}
		System.out.println("Hier gehts mit dem Rest des Programmes weiter");
         
	}

}
