package de.Imu;

import java.rmi.*;

public interface Fr�herkennungIF extends Remote {

	// die Methode gibt ein Renmote Object zur�ck
	public BerichtIF analysieren(R�ntgenBild bild) throws RemoteException;
}
