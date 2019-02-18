package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import Server.ChatServerIF;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF,Runnable {
     private ChatServerIF chatServer;
     private String name= null;

	protected ChatClient(String name,ChatServerIF chatserver) throws RemoteException {
		super();
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(new ChatClient(name,chatserver));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void retrieveMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String message = null;
		while(true)
		{
			message = scanner.nextLine();
			try
			{
				chatServer.broadcastMessage("name: "+message);
			}catch(RemoteException e)
			{
				e.printStackTrace();
			}
		}
	}

}
