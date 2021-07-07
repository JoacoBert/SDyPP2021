package EJ4b;

import java.awt.image.BufferedImage;
import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Client {

	private static Scanner sc = new Scanner(System.in);
	private static int _CORTES = 1;
	private static Long startTime, finalTime;
	private static String _SERVER = "localhost";
	private static int _PORT = 9000;

	private static String generateRoute(String route) {
		String routeParts[] = route.split("/");
		String result = "";
		for (int i = 0; i < (routeParts.length - 1); i++) {
			result = result + routeParts[i] + "/";
		}
		if (!result.isEmpty()) {
			result += "sobel.JPG";
		}

		return result;
	}

	private static String validateDirectory(String directory) {
		File d = new File(directory);
		while (!d.isFile()) {
			System.out.println("Error - " + directory + "no es un archivo. Inserte la ruta de la imagen");
			directory = sc.nextLine();
			d = new File(directory);
		}
		return directory;
	}

	public static void main(String[] args) {
		try {
			System.out.println("----- SOBEL FILTER RMI -------");

			Registry clientRMI = LocateRegistry.getRegistry(_SERVER, _PORT);
			ISobel isobel = (ISobel) clientRMI.lookup("service");
			System.out.println("Client RMI started");
			System.out.println("-----------------------------------------");
			System.out.println("Ingrese la ruta de la imagen (JPG) a la cual se le aplicara el filtro Sobel");			
			String route = sc.nextLine();
			while (route.isEmpty()) {
				System.out.println("ERROR!! Inserte la ruta de la imagen");
				route = sc.nextLine();
			}

			route = validateDirectory(route);
			File file = new File(route);

			BufferedImage image = ImageIO.read(file);
			System.out.println("Imagen cargada exitosamente");
			System.out.println("Se le esta aplicando el filtro Sobel");
			Imagen imagen = new Imagen(image, _CORTES);

			startTime = System.nanoTime();
			Imagen a = isobel.send(imagen);

			File fileResult = new File(generateRoute(route));
			ImageIO.write(a.getImage(), "JPG", fileResult);
			finalTime = System.nanoTime();

			System.out.println("Filtro aplicado! Su archivo se guardo en "+ generateRoute(route));
			System.out.println("Tiempo de proceso: " + ((finalTime - startTime) / 1000000) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}