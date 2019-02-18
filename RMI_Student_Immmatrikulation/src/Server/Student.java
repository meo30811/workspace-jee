package Server;

import java.io.Serializable;

public class Student implements Serializable {

	private long matrikelNr;
	private String name;
	private int ects;

	public Student()
	{
		this.ects =0;
	}
	/**
	 * @return the matrikelNr
	 */
	public long getMatrikelNr() {
		return matrikelNr;
	}

	/**
	 * @param matrikelNr the matrikelNr to set
	 */
	public void setMatrikelNr(long matrikelNr) {
		this.matrikelNr = matrikelNr;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ects
	 */
	public int getEcts() {
		return ects;
	}

	/**
	 * @param ects the ects to set
	 */
	public void setEcts(int ects) {
		this.ects = ects;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [matrikelNr=" + matrikelNr + ", name=" + name + ", ects=" + ects + "]";
	}





}
