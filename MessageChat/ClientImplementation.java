import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ClientImplementation extends UnicastRemoteObject implements Client {

	private int id;
	private String name;
	
	public ClientImplementation(String name, int id) throws RemoteException{
		super();
		setId(id);
		setName(name);
	}
	
	@Override
	public void setId(int id) throws RemoteException{
		this.id = id;
	}

	@Override
	public void setName(String name) throws RemoteException{
		this.name = name;
	}

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getId() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void showMessage(String message, String name) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(name + " : " + message);
		
	}
	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Boolean fluxControl = false;
		
		Server server = (Server) Naming.lookup("//127.0.0.1:8000/server");
		
		System.out.println("Insira o nome para um novo registro: ");
		
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.nextLine();
		
		server.register(name);
		
		while (!fluxControl) {
			String input = scanner.nextLine();
		
			String[] message = input.split(";");
			
			if (inputs.contains("/")) {
				server.directMessage(message[1], Integer.parseInt(message[0].replaceAll(";", "")));
			}
			else {
				server.publicMessage(message[1]);
			}
		}
	}

}
