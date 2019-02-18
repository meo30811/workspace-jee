package Server;

import java.rmi.RemoteException;
import java.util.*;
import Client.ChatClientIF;

public class ChatServer implements ChatServerIF {

	private ArrayList<ChatClientIF> chatClients = new ArrayList<ChatClientIF>();


	@Override
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
		// TODO Auto-generated method stub
		this.chatClients.add(chatClient);
	}

	@Override
	public synchronized void brodcastMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		int i=0;
		while(i<chatClients.size())
		{
			chatClients.get(i++).retrieveMessage(message);
		}
	}

}
