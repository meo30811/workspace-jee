package de.Imu;

import java.rmi.*;
import java.util.concurrent.Future;

public interface Fr�herkennungIF extends Remote {

	public Future<Bericht> analysieren(R�ntgenBild bild) throws RemoteException;
}
