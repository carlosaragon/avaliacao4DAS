import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
	
	public String getName() throws RemoteException;
	public int getId() throws RemoteException;
	public void showMessage(String message, String name) throws RemoteException;
	public void setName(String name) throws RemoteException;
	public void setId(int id) throws RemoteException;
}
