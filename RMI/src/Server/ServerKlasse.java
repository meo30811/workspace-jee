package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerKlasse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      

		try {
			// stub und skeleton as gateway erzeugen
			HalloIF hallo = new HalloImpl();
			HalloIF stub = (HalloIF)UnicastRemoteObject.exportObject(hallo,0);
			Registry r = LocateRegistry.createRegistry(1213);
			try {
				r.bind("servus", stub);
				System.out.println("Server starts!");
			} catch (AlreadyBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
