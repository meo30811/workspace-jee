package de.Imu;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    FrüherkennungIF f = new FrüherkennungServer();

		try {
			FrüherkennungIF stub = (FrüherkennungIF)UnicastRemoteObject.exportObject(f,0);
			Registry r = LocateRegistry.createRegistry(1213);
			r.bind("server", stub);// AlreadyBoundException
			System.out.println("Server starts!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
