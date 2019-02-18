package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MessagingIF messaging = new MessageServer();
      
       try {
		MessagingIF stub = (MessagingIF) UnicastRemoteObject.exportObject(messaging,0);
		Registry r = LocateRegistry.createRegistry(1213);
		r.bind("Messaging Server", stub);
		System.out.println("Server starts");
		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(AlreadyBoundException e)
     {
		
     }
	}

}
