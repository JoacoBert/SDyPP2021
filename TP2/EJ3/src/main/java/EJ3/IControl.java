package EJ3;

import java.rmi.Remote;

public interface IControl extends Remote {
	
	public void serverStop() throws java.rmi.RemoteException;

}
