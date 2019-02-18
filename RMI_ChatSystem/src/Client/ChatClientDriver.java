package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import Server.ChatServerIF;

public class ChatClientDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
           Registry r = LocateRegistry.getRegistry("localhost",1213);
           ChatServerIF serverstub= (ChatServerIF)r.lookup("ChatServer");
           // serverstub call by reference
           ChatClient client = new ChatClient("Olivier",serverstub);
           ChatClientIF clientstub = (ChatClientIF) UnicastRemoteObject.exportObject(client,0);
           clientstub.broadcastMessage();
           //
           
		}catch(RemoteException e)
		{
			
		}catch(NotBoundException e)
		{
			
		}
      
	}

}
