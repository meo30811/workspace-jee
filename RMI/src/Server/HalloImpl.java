package Server;

import java.rmi.RemoteException;

public class HalloImpl implements HalloIF {

	@Override
	public String hallo(String s) throws RemoteException {
		// TODO Auto-generated method stub
		return " hello Client:"+s;
	}

}
