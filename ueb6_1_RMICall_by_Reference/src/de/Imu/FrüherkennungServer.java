package de.Imu;

import java.rmi.RemoteException;
import java.util.*;

public class Fr�herkennungServer implements Fr�herkennungIF {

	@Override
	public Bericht analysieren(R�ntgenBildIF bild) {
		// TODO Auto-generated method stub
		try {
			System.out.println("R�ntgenBild empfangen: "+ bild.ausgabe());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Bericht();
	}

}
