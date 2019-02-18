package de.Imu;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.io.Serializable;
import java.rmi.*;

public class BerichtFuture implements Future<Bericht> ,Serializable{

	  private boolean istAbgebrochen = false;
	  private final AnalyseIF analyseStub;


	  public BerichtFuture(AnalyseIF analyseStub) {
	        this.analyseStub = analyseStub;
	    }

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		 try {
	            analyseStub.abbrechen();
	            istAbgebrochen = true;
	        } catch (RemoteException ex) {
	            //
	        }
		return true;
	}

	@Override
	public Bericht get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		 Bericht bericht = null;
	        try {
	            bericht = analyseStub.abholen();
	        } catch (AccessException ex) {
	            //
	        } catch (RemoteException ex) {
	            //
	        }

	        return bericht;
	}

	@Override
	public Bericht get(long arg0, TimeUnit arg1) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Fuer Beispiel nicht implementiert.");
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return this.istAbgebrochen;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		  try {
	            return this.analyseStub.isAbholbereit();
	        } catch (RemoteException ex) {
	            return false;
	        }

	}

}
