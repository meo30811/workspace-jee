package Client;

import Server.HalloIF;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientKlasse {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		try
		{
         Registry r = LocateRegistry.getRegistry("localhost",1213);
         try {
			HalloIF hallo = (HalloIF) r.lookup("servus");
			String antwort = hallo.hallo("Olivier");
			System.out.println(antwort);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch(RemoteException e){}
	}

}
