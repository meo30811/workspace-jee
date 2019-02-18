package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.ChatClientIF;

public interface ChatServerIF extends Remote {

	public void registerChatClient(ChatClientIF chatClient) throws RemoteException;
	public void broadcastMessage(String message) throws RemoteException;
}
