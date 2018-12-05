import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImplementation extends UnicastRemoteObject implements Server{

	private ArrayList<Client> clients = new ArrayList<Client>();
	
	protected ServerImplementation() throws RemoteException {}
	
	@Override
	public void directMessage(String message, int id) throws RemoteException {
		int i = 0;
		while(i < clients.size()) {
			if (clients.get(i).getId() == id) {
				Client newClient = (Client) clients.get(i);
				newClient.showMessage(message, clients.get(i).getName());
				i = clients.size() + 2;
			}
		}
		
	}

	@Override
	public void publicMessage(String message) throws RemoteException {
		int i = 0;
		while (i < clients.size()) {
			Client newClient = (Client) clients.get(i);
			newClient.showMessage(message, clients.get(i).getName());
			i = clients.size() + 2;
		}
		
	}
	
//Registra novos usuarios
	
	@Override
	public void register(String name) throws RemoteException {
		System.out.println("Nome do usuario:" + name);
		Client newClient = new ClientImplementation(name, clients.size()+1);
		clients.add(newClient);
	}
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(8000);
			Server server = new ServerImplementation();
			registry.bind("server", server);
			
		} catch (Exception e) {
		}
	}
	

}
