package de.client;
import de.Imu.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class Uniklinik_Regensburg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner eingabe = new Scanner(System.in);
			System.out.println("Bitte geben Sie ein Hostname ein: ");
			String hostname = eingabe.nextLine();

			Registry r = LocateRegistry.getRegistry(hostname,1213);// NotBoundException
		    FrüherkennungIF f = (FrüherkennungIF)r.lookup("server");// Throws NotBoundException
		    RöntgenBild b = new RöntgenBild();
		    Bericht bericht = f.analysieren(b);

            System.out.println("Bericht von "+b.getPatientName());
            System.out.println("==========================");
            System.out.println("RöntgenBild:  "+b.getRawData());
            System.out.println("Aufnahme vom: "+b.getAufnahmeVom());
            System.out.println("Diagnose: "+bericht.getDiagnose());
            System.out.println("Date: "+bericht.getDate());
            System.out.println("weiteres Vorgehen: "+bericht.getWeiteresVorgehen());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NotBoundException e)
		{

		}

	}

}
