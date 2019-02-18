package Server;

import java.rmi.*;

public interface ImmatrikulationIF extends Remote {

	public Student immatrikulieren(Student s) throws RemoteException ;
}
