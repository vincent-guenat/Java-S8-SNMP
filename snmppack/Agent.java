package snmppack;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Agent extends SocketWrapper implements Runnable {
    public Agent(int portA, InetAddress addrA) {
        super(portA, addrA);
    }

    public Agent(int portA, String addrA) throws UnknownHostException {
        super(portA, addrA);
    }

    @Override
	public void run() {
		while(!Thread.currentThread().isInterrupted() && socket != null)
		{
			DatagramPacket data = new DatagramPacket(tampon,tampon.length);
            receptMsg(data);
		}
	}

    @Override
    public String toString() {
        return "Agent : " + super.toString();
    }
}
