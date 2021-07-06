package EJ3;

import java.rmi.NotBoundException;
import java.util.Scanner;

public class Main {
	private void newClient(final int n) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Client c = new Client(n);
				try {
					c.clientUp();
					Thread.sleep(200);
				} catch (NotBoundException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}).start();
		
		
	}
	
	public Main() {

		System.out.println("Ingrese la cantidad de clientes que atendera el sistema");
		Scanner teclado = new Scanner(System.in);

		int rep = teclado.nextInt();

		for (int i=0; i<rep; i++) {
			newClient(i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {	
		Balanceador balancer = new Balanceador();
		balancer.initBalancer();
		new Main();
		

	}          
}
