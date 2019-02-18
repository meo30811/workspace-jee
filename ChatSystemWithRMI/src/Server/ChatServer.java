package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import Client.ChatClientIF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {

	private ArrayList<ChatClientIF> chatClients ;
	protected ChatServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.chatClients = new ArrayList<ChatClientIF>();
	}

	@Override
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
		// TODO Auto-generated method stub
         this.chatClients.add(chatClient);
	}

	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
        int i=0;
        while(i< chatClients.size())
        {
        	chatClients.get(i++).retrieveMessage(message);
        }
	}

}
