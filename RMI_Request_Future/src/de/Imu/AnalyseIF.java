package de.Imu;

import java.rmi.*;

public interface AnalyseIF extends Remote {
	 public Bericht abholen() throws RemoteException;
	 public boolean isAbholbereit() throws RemoteException;
	 public void abbrechen() throws RemoteException;
}
