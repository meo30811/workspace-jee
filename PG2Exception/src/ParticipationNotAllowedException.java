
public class ParticipationNotAllowedException extends Exception {

	private Teilnehmer problemFall;

	public Teilnehmer getProblemFall() {
		return problemFall;
	}

	public void setProblemFall(Teilnehmer problemFall) {
		this.problemFall = problemFall;
	}
}
