package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

public class ServerClass implements ImmatrikulationIF {

	private static int letzesMatrikelNr = 1;
	
	public static void main(String[] args)
	{

		try {
			System.out.println("Intanz und Stub generieren");
			ImmatrikulationIF server = new ServerClass();
			// reference in RMI ist ein Stub eines Remote Object
			ImmatrikulationIF stub = (ImmatrikulationIF) UnicastRemoteObject.exportObject(server,0);

			System.out.println("An Registry binden");
			Registry r = LocateRegistry.createRegistry(1213);
			r.bind("OTHImmatriculation Service", stub);

			System.out.println("welcome to OTH immatriculation service!");

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(AlreadyBoundException e)
		{
			e.printStackTrace();
		}

	}
	@Override
	public Student immatrikulieren(Student s) throws RemoteException {
		// TODO Auto-generated method stub
		s.setMatrikelNr(letzesMatrikelNr++);
		System.out.println("lege Student in Datenbank an: "+s.toString());
		return s;
	}

}
