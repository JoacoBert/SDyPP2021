package EJ2B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Menu implements Runnable {
    PrintWriter canalSalida = new PrintWriter(System.out, true);
    BufferedReader canalEntrada = new BufferedReader(new InputStreamReader(System.in));

    public void MenuPrincipal() {
        boolean menu = true;
        while (menu) {
            try {
                canalSalida.println("||==============================================================||");
                canalSalida.println("||                Ruleta del Casino de Pinamar                  ||");
                canalSalida.println("||==============================================================||");
                canalSalida.println("Seleccione una opción del menú");
                canalSalida.println("1 -- Automatico ");
                canalSalida.println("2 -- Manual");
                canalSalida.println("0 -- Salir");
                int option = leerOpcion(0, 7);
                switch (option) {
                    case 1:
                        automatico();
                        break;
                    case 2:
                        break;
                    case 0:
                        menu = false;
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

	private int leerOpcion(int valorMax, int valorMin) {
        int option = valorMax - 1;
        while (option < valorMax || option > valorMin) {
            try {
                option = Integer.valueOf(canalEntrada.readLine());
            } catch (Exception e) {
                option = valorMax - 1;
            }
        }
        return option;
    }

	public void automatico() {

		double dineroInicial = 10000;
		double sum = dineroInicial;
		
		try {
			CuentaBanco cuentaBanco = new CuentaBanco(dineroInicial);
			Random random = new Random();		
			ArrayList<Thread> threads = new ArrayList<Thread>();
			Thread t;
			
			
			for(int i=0; i<5; i++) {
				ClienteBanco cliente = new ClienteBanco(i,random.nextInt(5000),random.nextInt(5000),cuentaBanco);
				System.out.println(cliente.clienteToString());
				sum += cliente.diferencia();
				t = new Thread(cliente);
				threads.add(t);
				t.start();
			}
		System.out.println("Su balance final es: "+ sum +"?");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

    @Override
    public void run() {
        MenuPrincipal();

    }
}

