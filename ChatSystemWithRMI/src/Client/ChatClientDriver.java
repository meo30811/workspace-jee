package Client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import Server.ChatServerIF;

public class ChatClientDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try {
		Registry r = LocateRegistry.getRegistry("localhost",1213);
		ChatServerIF chatServer = (ChatServerIF) r.lookup("ChatServer");
		System.out.println(chatServer);
		new Thread(new ChatClient("Olivier",chatServer)).start();

	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(NotBoundException e)
     {
		e.printStackTrace();
     }


	}

}
