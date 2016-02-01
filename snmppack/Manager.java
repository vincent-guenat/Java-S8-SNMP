package snmppack;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

public class Manager extends SocketWrapper implements Runnable {

	public Manager(int portA, InetAddress addrA) {
		super(portA, addrA);
	}

	public Manager(int portA, String addrA) throws UnknownHostException {
		super(portA, addrA);
	}
	
	public void run() {
		envoieMsg("127.0.0.1", 20000, "Bonjour");
	}

    @Override
    public String toString() {
        return "Manager : " + super.toString();
    }
	
}
