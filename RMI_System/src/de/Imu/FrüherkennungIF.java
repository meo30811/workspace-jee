package de.Imu;

import java.rmi.*;

public interface FrüherkennungIF extends Remote {

	public Bericht analysieren(RöntgenBild bild) throws RemoteException;
}
