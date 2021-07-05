package main.java.EJ4A;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Client {

	
	private static Scanner sc = new Scanner(System.in);
	private static int _CORTES =1;
	private static Long startTime, finalTime;
	
	private static String generateRoute(String route) {
		String routeParts[] = route.split("/");
		String result = "";	
			for(int i=0; i<(routeParts.length-1);i++) {
				result = result + routeParts[i] + "/";
			}
		if (!result.isEmpty()) {
			result += "sobelCentralizado.jpg";
		}
		
		return result;
	}
	
	private static String validateDirectory(String directory) {
		File d = new File(directory);
			while(!d.isFile()) {
				System.out.println("Error - " + directory + "no es un archivo. Inserte la ruta de la imagen");
				directory = sc.nextLine();
				d = new File(directory);
			}
		return directory;
	}
	
	public static void main(String[] args)  {
		
		try {
			System.out.println("-------- SOBEL FILTER --------");
			System.out.println("Ingrese la ruta de la imagen (JPG) a la cual se le aplicara el filtro Sobel");
			
            String route = sc.nextLine();
				while (route.isEmpty()){
					System.out.println("ERROR!! Inserte la ruta de la imagen");
					route = sc.nextLine();
				}
			
				route = validateDirectory(route);
				
			File file = new File(route);
			BufferedImage image = ImageIO.read(file);
			System.out.println("Imagen cargada exitosamente");
			System.out.println("Se le esta aplicando el filtro Sobel");
			
			startTime = System.nanoTime();
			ImageManipulation imageManipulation = new ImageManipulation(image, _CORTES);
			ArrayList<BufferedImage> imageParts = imageManipulation.cutImage();
			ArrayList<BufferedImage> imageParts_with_Sobel = new ArrayList<BufferedImage>();
			
				for(BufferedImage img : imageParts) {
					Sobel sobel = new Sobel(img);
					imageParts_with_Sobel.add(sobel.applyFilter());
				}
			
				BufferedImage result = imageManipulation.joinImage(imageParts_with_Sobel);
			
			File fileResult = new File(generateRoute(route));
			ImageIO.write(result, "JPG", fileResult);
			finalTime = System.nanoTime();
			
			System.out.println("Done! Your file is located at " + generateRoute(route));
			System.out.println("Processing time: " + ((finalTime-startTime)/1000000) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
