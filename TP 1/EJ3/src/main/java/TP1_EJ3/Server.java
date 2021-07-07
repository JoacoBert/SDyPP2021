package TP1_EJ3;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
	
	List<String> usuarios;
	Mailbox mailbox = new Mailbox();
	
	public Server(int port){
        try{
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server has started on TCP port "+port);
            usuarios = Collections.synchronizedList(new ArrayList<String>());
            
                Socket client = ss.accept();
                ServerHilo sh = new ServerHilo(client, usuarios, mailbox);
                Thread serverThread = new Thread(sh);
                serverThread.start();
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


