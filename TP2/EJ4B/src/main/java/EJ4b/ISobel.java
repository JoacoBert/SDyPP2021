package EJ4b;

import java.rmi.Remote;

public interface ISobel extends Remote{

	public Imagen send(Imagen image) throws java.rmi.RemoteException;
}
