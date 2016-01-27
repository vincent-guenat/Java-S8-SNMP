package snmppack;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Properties;

public class Manager extends Agent{
		
	
	
	
	
	public void sendmess(InetSocketAddress addrA, int port, Message mess) throws SocketException{
		byte[] tampon = new byte[1000];

	    // crée un socket UDP qui attends des datagrammes sur le port 2000
		DatagramSocket socket = new DatagramSocket();	
		// crée un objet pour envoyer les données du datagramme 
		System.out.println("Socket ouvert sur le port :"+socket.getLocalPort()+" \n avec l'adresse : "+socket.getLocalAddress());
		DatagramPacket envoi=new DatagramPacket(tampon,tampon.length,addrA);
		System.out.println("emission");
		
		try {
			socket.send(envoi);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		
	}
	
	
}
