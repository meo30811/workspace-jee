package Server;

import java.rmi.*;

public interface HalloIF extends Remote {

	public String hallo(String s) throws RemoteException;
}
