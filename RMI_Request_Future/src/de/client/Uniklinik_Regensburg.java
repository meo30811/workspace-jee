package de.client;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import de.Imu.*;

public class Uniklinik_Regensburg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Scanner eingabe = new Scanner(System.in);
			System.out.println("Bitte geben Sie ein Hostname ein: ");
			String hostname = eingabe.nextLine();

			Registry r = LocateRegistry.getRegistry(hostname,1213);// NotBoundException
		    FrüherkennungIF f = (FrüherkennungIF)r.lookup("Analysis Service");// Throws NotBoundException

		    RöntgenBild bild = new RöntgenBild();
            // hier wird das RöntgenBild bei reference uebergeben
		    Future<Bericht> berichtFuture= f.analysieren(bild);


		    boolean berichtFertig = false;
            do {
                try {
					TimeUnit.SECONDS.sleep(1);
					berichtFertig = berichtFuture.isDone();
		            System.out.println("Bericht liegt noch nicht vor. Warte 1 Sek. ...");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            } while(!berichtFertig);

            Bericht bericht;
            try {

					bericht = berichtFuture.get();
					System.out.println("Bericht von München");
		            System.out.println("------------------");
		            System.out.println("Diagnose: "+bericht.getDiagnose());
		            System.out.println("Date: "+bericht.getDate());
		            System.out.println("weiteres Vorgehen: "+bericht.getWeiteresVorgehen());

            } catch (ExecutionException ex) {
                System.out.println("Fehler");
                return;
            }catch(InterruptedException e)
            {

            }

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NotBoundException e)
		{

		}

	}

}
