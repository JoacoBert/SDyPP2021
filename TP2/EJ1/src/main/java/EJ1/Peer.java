package EJ1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/

public class Peer {

	//private final static Logger log = LoggerFactory.getLogger(Peer.class);
	private static String name;
	private static String _SERVER = "localhost";
	private static int _PORTMASTER = 9000;
	private static Socket socketPeer;
	private static BufferedReader inputChannel;
	private static BufferedReader canalEntrada;
	
	private static PrintWriter outputChannel;
	private static Scanner read = new Scanner(System.in);
	private static String option = null;
	private static ArrayList<String> fileToShare = new ArrayList<String>();
	private static int _PORTSERVER;

	private static int changeOption(String option) {
		option.toUpperCase();
		if ((option.equalsIgnoreCase("Download file")) || (option.equalsIgnoreCase("DOWNLOAD"))
				|| (option.equalsIgnoreCase("D")) || (option.equalsIgnoreCase("Y")) || (option.equalsIgnoreCase("1"))) {
			return 1;
		} else if ((option.equalsIgnoreCase("View shared files")) || (option.equalsIgnoreCase("Views"))
				|| (option.equalsIgnoreCase("V")) || (option.equalsIgnoreCase("N")) || (option.equalsIgnoreCase("2"))) {
			return 2;
		} else {
			return 5;
		}

	}

	private static void menuPeer() {
		System.out.println("--------- Peer menu ---------");
		System.out.println("Choose one option");
		System.out.println("1- Download file");
		System.out.println("2- View shared files");
		System.out.println("5- Exit");
		option = read.nextLine();
	}

	private static String validateDirectory(File d, String directory) {
		d = new File(directory);
		while (!d.isDirectory()) {
			System.out.println("Error - " + directory + "is not a directory. Please insert a new directory");
			directory = read.nextLine();
			d = new File(directory);
		}
		return directory;
	}

	public static void startPeer(int puerto, String ip) {

		_SERVER = ip;
		_PORTMASTER= puerto;

		try {
			int intentos = 0;
			boolean flag = false;
			while (!flag) {
				System.out.println("[PEER] - Trying connect to server");

				// log.info("[PEER] - Trying connect to server");
				try {
					socketPeer = new Socket(_SERVER, _PORTMASTER);
					System.out.println("[PEER] - Socket created: " + _SERVER + ":" + _PORTMASTER);

					// log.info("[PEER] - Socket created: " + _SERVER + ":" + _PORTMASTER);
					flag = true;
				} catch (IOException e) {
					intentos++;

				}
				if (intentos >= 3) {
					flag = true;
					System.err.println("[PEER] - Server not found");

					// log.error("[PEER] - Server not found");
					System.exit(0);
				}
			}

			canalEntrada = new BufferedReader(new InputStreamReader(socketPeer.getInputStream()));

			System.out.println("--------- Peer menu ---------");
			System.out.println("Insert directory of download");
			String directory = read.nextLine();
			File d = new File(directory);

			directory = validateDirectory(d, directory);

			System.out.println("Insert directory to share");
			String share = read.nextLine();
			d = new File(share);

			share = validateDirectory(d, share);

			File fshare = new File(share);

			String[] filesNames = fshare.list();

			for (int i = 0; i < filesNames.length; i++) {
				fileToShare.add(filesNames[i]);
			}

			System.out.println("[PEER] - Send directory to server");
			// log.info("[PEER] - Send directory to server");

			outputChannel = new PrintWriter(socketPeer.getOutputStream(), true);

			outputChannel.println("initialConfiguration@" + fileToShare + "@" + directory + "@" + share);
			outputChannel.flush();

			inputChannel = new BufferedReader(new InputStreamReader(socketPeer.getInputStream()));

			String initial = inputChannel.readLine();
			String initialParts[] = initial.split("@");
			name = initialParts[0];
			_PORTSERVER=Integer.parseInt(initialParts[1]);

			
			PeerServer peerServer = new PeerServer(_PORTSERVER);
			Thread threadPeerServer = new Thread(peerServer);
			threadPeerServer.start();
			

			menuPeer();
			while (changeOption(option) != 5) {

				switch (changeOption(option)) {

					case 1:
						System.out.println("What file do you want?");
						String file = read.nextLine();
						System.out.println("[PEER] - Send download to server");
						// log.info("[PEER] - Send download to server");
						outputChannel.println("download@" + file);
						String msgServer = inputChannel.readLine();
						if (!msgServer.startsWith("fileNotFound")) {
							String[] msgServerParts = msgServer.split("@");

							System.out.println("Choose server to download the file: (INSERT NUMBER OF PEER)");
							int j = 1;

							for (int i = 1; i < msgServerParts.length; i++) {
								if (i == j) {
									j += 3;
									System.out.println(">> Server Peer:" + msgServerParts[i]);
								}
							}

							String serv = read.nextLine();
							Integer port = null;
							String route = null;

							for (int i = 0; i < msgServerParts.length; i++) {
								if (msgServerParts[i].equalsIgnoreCase(serv)) {
									port = Integer.parseInt(msgServerParts[i + 1]);
									route = msgServerParts[i + 2];
								}
							}


							PeerClient peerClient = new PeerClient(port,file,route,directory);
							Thread threadPeerClient = new Thread(peerClient);
							threadPeerClient.start();
							fileToShare.add(file);
							outputChannel.println("updateFiles@" + name +"@"+file);
							System.out.println("[PEER] - File received");
							// log.info("[PEER] - File received");
						} else {
							System.out.println("[PEER] - File not found");
							// log.info("[PEER] - File not found");
						}
						menuPeer();
						break;

					case 2:
						System.out.println("Shared files:");
						for (int i = 0; i < fileToShare.size(); i++) {
							System.out.println(fileToShare.get(i));
						}
						menuPeer();
						break;
					default:
						System.out.println("Wrong");
						break;
				}

			}
			if (changeOption(option) == 5) {
				outputChannel.println("Bye@" + name);
				outputChannel.close();
				inputChannel.close();
				socketPeer.close();
				System.exit(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String packetName = Peer.class.getSimpleName().toString();
		//System.setProperty("log.name", packetName);

		int puerto = 9000;
        String ip = "127.0.0.1";
        if(args.length == 1)
        	ip = args[0];
		startPeer(puerto, ip);

	}

}
