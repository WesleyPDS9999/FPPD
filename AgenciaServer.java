import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class AgenciaServer 
{

	public static void main (String[] args) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");			
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");			
		}
		try {
			Naming.rebind("Agencias", (Remote) new Administracao ());
			System.out.println("NotasServer is ready.");
		} catch (Exception e) {
			System.out.println("NotasServer failed:");
			e.printStackTrace();
		}
	}
	
}

