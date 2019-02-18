package de.Imu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FrüherkennungServer implements FrüherkennungIF {

	ExecutorService threadPool = Executors.newCachedThreadPool();

	@Override
	public Future<Bericht> analysieren(RöntgenBild bild) throws RemoteException {
		// TODO Auto-generated method stub
		 System.out.println("Roentgenbild vom " + bild.getAufnahmeVom() + " wurde empfangen und wird spaeter analysiert!");

	        // Dediziertes Analyseobjekt (Thread/Runnable) fuer jede Analyseanfrage
	        Analyse analyse = new Analyse(bild);

	        // Analyse ist Server-Stub fuer das zurueckgegebene Future-Objekte
	        // (Future hat intern Stub, um mit dieser Instanz zu kommunizieren, deshalb exportObject...)
	        AnalyseIF analyseStub = (AnalyseIF) UnicastRemoteObject.exportObject(analyse, 0);

	        // Statt new Thread(analyse).start() besser ueber einen ThreadPool (s. o.)
	        threadPool.execute(analyse);

	        // Nicht auf Ende der Analyse warten sondern Future<Bericht>-Objekt zurueckgeben
	        return new BerichtFuture(analyseStub);
	}

}
