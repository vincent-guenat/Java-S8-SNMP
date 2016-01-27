package snmppack;

import java.net.SocketException;


public class ThreadPrinc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Interface inter = new Interface();
		//inter.choixInit();
		Message mess = new Message("bonjour");
		Agent agent = new Agent();
		
		//Agent agent2 = new Agent();	
		Thread th1 = new Thread(agent); 	
		// Parce que t1 est implement Runnable
		th1.start(); 					
		// Surtout pas run		
		//Thread th2 = new Thread(agent2);
		//th2.start();
		
		Manager man = new Manager();
		
	}

}
