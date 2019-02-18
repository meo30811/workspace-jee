package Client;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.io.Serializable;
import java.rmi.*;
import Server.ChatServerIF;

public class ChatClient implements ChatClientIF, Serializable {

	private ChatServerIF chatserver;
	private String name = null;

	public ChatClient(String name,ChatServerIF chatserver)
	{
		this.name = name;
		this.chatserver = chatserver;
		try {
			chatserver.registerChatClient(this);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void retrieveMessage(String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(message);
	}

	@Override
	public void broadcastMessage() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String message = null;
		do
		{
			message = scan.nextLine();
			try
			{
				chatserver.brodcastMessage("name : "+message);
			}catch(RemoteException e)
			{
			  e.printStackTrace();
			}

		}while(message!=null && !message.equalsIgnoreCase("bye"));
	}


}
