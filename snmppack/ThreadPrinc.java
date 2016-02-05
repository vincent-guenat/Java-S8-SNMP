package snmppack;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class ThreadPrinc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Interface inter = new Interface();
		//inter.choixInit();
		//Message mess = new Message("bonjour");
		Agent agent = null;
		try {
			agent = new Agent(20000, "127.0.0.1");
			Thread th1 = new Thread(agent);
			th1.start();
		} catch (UnknownHostException e) {
			System.err.println("Invalide Host addresse" + e);
		}

        Manager man = null;
        try {
            man = new Manager(20001,"0.0.0.0");
            Thread th2 = new Thread(man);
            th2.start();
        } catch (UnknownHostException e) {
            System.err.println("Invalide Host addresse\n" + e);
        }

		//th1.notifyAll();
		
	}

}
