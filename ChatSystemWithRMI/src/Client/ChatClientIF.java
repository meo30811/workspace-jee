package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientIF extends Remote {

	public void retrieveMessage(String message)throws RemoteException;

}
