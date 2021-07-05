package EJ2A;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		double dineroInicial = (5000+random.nextInt( (10000+1) - 5000));
		int cantClientes = (5+random.nextInt( (20+1) - 5));
		
		PrintWriter canalSalida = new PrintWriter(System.out, true);

		canalSalida.println("Dinero inicial: " + dineroInicial);
		canalSalida.println("Clientes que operan sobre la cuenta: " + cantClientes);		
        double sum = dineroInicial;

		canalSalida.println("--------------------------------------------------------------");
        try {
			CuentaBanco cuentaBanco = new CuentaBanco(dineroInicial);
				
			int dineroDepExt = (int) (dineroInicial / 2);	
			ArrayList<Thread> threads = new ArrayList<Thread>();
			Thread t;
					
			for(int i=0; i<cantClientes; i++) {
				ClienteBanco cliente = new ClienteBanco(i, random.nextInt(dineroDepExt), random.nextInt(dineroDepExt),
				cuentaBanco);
				System.out.println(cliente.clienteToString());
				sum += cliente.diferencia();
				t = new Thread(cliente);
				threads.add(t);
				t.start();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Su balance final es: "+ sum +"?");
	}
}
