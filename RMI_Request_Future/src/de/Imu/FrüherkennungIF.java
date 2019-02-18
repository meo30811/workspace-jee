package de.Imu;

import java.rmi.*;
import java.util.concurrent.Future;

public interface FrüherkennungIF extends Remote {

	public Future<Bericht> analysieren(RöntgenBild bild) throws RemoteException;
}
