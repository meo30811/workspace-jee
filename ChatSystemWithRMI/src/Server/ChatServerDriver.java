package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;

public class ChatServerDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
		ChatServerIF stub = new ChatServer();
		//ChatServerIF stub= (ChatServerIF) UnicastRemoteObject.exportObject(s,0);
		Registry r = LocateRegistry.createRegistry(1213);
		r.bind("ChatServer",stub);
		System.out.println("Server runs!");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(AlreadyBoundException e)
     {
		e.printStackTrace();
     }
   }
}
