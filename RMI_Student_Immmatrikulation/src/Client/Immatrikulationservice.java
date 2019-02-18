package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;
import Server.ImmatrikulationIF;
import Server.Student;

public class Immatrikulationservice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		   Registry r = LocateRegistry.getRegistry("localhost",1213);
		   ImmatrikulationIF server = (ImmatrikulationIF) r.lookup("OTHImmatriculation Service");
		   Student student = new Student();
		   student.setName("Olivier Messeumeni");
		   student.setMatrikelNr(456123);
		   Student st= server.immatrikulieren(student);
		   System.out.println("Client sent the Message");
           
		}catch(RemoteException e)
		{
			e.printStackTrace();

		}catch(NotBoundException e)
		{
			e.printStackTrace();
		}


	}

}
