package Server;

import java.rmi.*;
import java.util.List;

public interface MessagingIF extends Remote{

  public User registrieren(User user) throws RemoteException;
  public Message senden(User receiver,Message m)throws RemoteException;
  public List<Message> empfangen(User ich)throws RemoteException;
}
