package de.Imu;

import java.rmi.*;

public interface Fr�herkennungIF extends Remote {

	public Bericht analysieren(R�ntgenBild bild) throws RemoteException;
}
