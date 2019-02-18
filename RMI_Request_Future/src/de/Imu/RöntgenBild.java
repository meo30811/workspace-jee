package de.Imu;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.*;

public class R�ntgenBild implements Serializable{

  private Date aufnahmeVom;
  private byte[] rawData;
  transient String patientName;

  public R�ntgenBild()
  {
	  this.aufnahmeVom= Calendar.getInstance().getTime();
	  this.rawData = new byte[]{ 0x30,0x12,0x12};
	  this.patientName ="nelson Noumen";
  }
  public R�ntgenBild(Date aufnameVom, byte[] rawData, String patientName)
  {
	  this.aufnahmeVom = aufnameVom;
	  this.rawData = rawData;
	  this.patientName = patientName;
  }
/**
 * @return the aufnahmeVom
**/
public Date getAufnahmeVom() {
	return aufnahmeVom;
}
/**
 * @param aufnahmeVom the aufnahmeVom to set
 */

public void setAufnahmeVom(Date aufnahmeVom) {
	this.aufnahmeVom = aufnahmeVom;
}
/**
 * @return the rawData
 */

public byte[] getRawData() {
	return rawData;
}
/**
 * @param rawData the rawData to set
 */

public void setRawData(byte[] rawData) {
	this.rawData = rawData;
}
/**
 * @return the patientName
 */

public String getPatientName() {
	return patientName;
}
/**
 * @param patientName the patientName to set
 */
 
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String ausgabe() throws RemoteException {
	// TODO Auto-generated method stub
  return "R�ntgenBild [aufnahmeVom=" + aufnahmeVom + ", rawData=" + Arrays.toString(rawData) + "]";
}

}
