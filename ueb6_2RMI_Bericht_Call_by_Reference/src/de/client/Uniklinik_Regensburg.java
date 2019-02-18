package de.client;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import de.Imu.*;

public class Uniklinik_Regensburg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner eingabe = new Scanner(System.in);
			System.out.println("Bitte geben Sie ein Hostname ein: ");
			String hostname = eingabe.nextLine();

			Registry r = LocateRegistry.getRegistry(hostname,1213);// NotBoundException
		    Fr�herkennungIF f = (Fr�herkennungIF)r.lookup("Analysis Service");// Throws NotBoundException

		    R�ntgenBild bild = new R�ntgenBild();
		   
		    
            // hier wird das R�ntgenBild bei reference uebergeben
		    BerichtIF stub = f.analysieren(bild);
            
            System.out.println("Bericht von "+bild.getPatientName());
            System.out.println("==========================");
            System.out.println("R�ntgenBild:  "+bild.getRawData());
            System.out.println("Aufnahme vom: "+bild.getAufnahmeVom());
            System.out.println("Diagnose: "+stub.getDiagnose());
            System.out.println("Date: "+stub.getDate());
            System.out.println("weiteres Vorgehen: "+stub.getWeiteresVorgehen());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NotBoundException e)
		{

		}

	}

}
