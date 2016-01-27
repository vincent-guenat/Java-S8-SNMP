package snmppack;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Agent  implements Runnable {
	
		//private MIB mib;
		//Port par défaut (test)
	
	public void opensocketecoute() throws SocketException{	
		byte[] tampon = new byte[1000];
			
	    // crée un socket UDP qui attends des datagrammes sur le port 2000
		DatagramSocket socket = new DatagramSocket(2000);	
		// crée un objet pour stocker les données du datagramme attendu
		System.out.println("Socket ouvert sur le port :"+socket.getLocalPort()+" \n avec l'adresse : "+socket.getLocalAddress());
		DatagramPacket reception = new DatagramPacket(tampon, tampon.length);
		System.out.println("Attente de reception");
		try {
			socket.receive(reception);
			
			// Note: reception.getLength() contient le nombre d’octets reçus
			
			String texte =new String(tampon, 0, reception.getLength());
			System.out.println(texte);
			Thread.sleep(100);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	    
		
	}

		@Override
		public void run() {
			try {
				opensocketecoute();
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	

}
