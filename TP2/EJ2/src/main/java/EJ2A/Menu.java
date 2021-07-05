package EJ2A;

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

        try {
            canalSalida.println("||==============================================================||");
            canalSalida.println("||                         Sistema Bancario                     ||");
            canalSalida.println("||==============================================================||");
            canalSalida.println("Seleccione una opción del menú");
            canalSalida.println("1 -- Realizar operaciones de extración y depositos ");
            canalSalida.println("0 -- Salir");
            int option = leerOpcion(0, 7);
            switch (option) {
                case 1:
                    automatico();
                    break;
                case 0:
                    menu = false;
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    public void automatico() throws NumberFormatException, IOException {

      
    }

    @Override
    public void run() {
        MenuPrincipal();

    }
}
