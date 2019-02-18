package de.Imu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import de.client.*;

public class Fr�herkennungServer implements Fr�herkennungIF {

	@Override
	public void analysieren(R�ntgenBild bild, BerichtCallbackIF bericht) throws RemoteException {
		// TODO Auto-generated method stub	
		System.out.println("Roentgenbild vom " + bild.getAufnahmeVom() + " wird analysiert! Dauert ca. 10 Sekunden...");
	    Analysis analyse = new Analysis(bericht);
	    new Thread(analyse).start();
	}

}
