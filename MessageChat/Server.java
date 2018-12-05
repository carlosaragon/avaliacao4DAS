import java.rmi.*;

public interface Server extends Remote {

	public void directMessage(String message, int id) throws RemoteException;
	public void publicMessage(String message) throws RemoteException;
	public void register(String name) throws RemoteException;
}
