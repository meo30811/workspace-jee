package de.Imu;

import java.rmi.*;
import de.client.*;
public interface Fr�herkennungIF extends Remote {

	// die Methode gibt ein Renmote Object zur�ck
	public void analysieren(R�ntgenBild bild, BerichtCallbackIF bericht) throws RemoteException;
}
