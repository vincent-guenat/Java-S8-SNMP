package snmppack;

import java.io.IOException;
import java.net.*;


public class SocketWrapper {
    protected final static byte tampon[] = new byte[1024];

    protected int portA;
    protected InetAddress addrA;
    protected DatagramSocket socket;

    public SocketWrapper (int portA, InetAddress addrA) {
        this.portA = portA;
        this.addrA = addrA;
        this.socket = initSocket();
    }

    public SocketWrapper(int portA, String addrA) throws UnknownHostException {
        this(portA, InetAddress.getByName(addrA));
    }

    private DatagramSocket initSocket() {
        try {
            socket = new DatagramSocket(portA,addrA);
            System.out.println("Socket ouvert pour "  + this);
        }
        catch (SocketException e) {
            error("Erreur lor de la creation du socket : " + e );
            Thread.currentThread().interrupt();
        }
        return socket;
    }

    protected boolean receptMsg (DatagramPacket data) {
        try {
            socket.receive(data);
            System.out.println("Reception sur"  + this + " depuis " + data.getAddress() + ":" + data.getPort() +" : " + new String(data.getData()));
            return true;
        }
        catch (IOException e) {
            error("Erreur lors de la reception de données : " + e );
            return false;
        }
    }

    protected boolean envoieMsg(InetAddress serveur, int port, String data) {
        try {
            int length = data.length();
            byte buffer[] = data.getBytes();
            DatagramPacket dataSent = new DatagramPacket(buffer,length,serveur,port);
            socket.send(dataSent);
            System.out.println("Envoie depuis " + this + " vers " + serveur + ":"+ port + "  : " + new String(dataSent.getData()));
            return true;
        }
        catch (IOException e) {
            error("Erreur lors de l'envoie de données : " + e );
            return false;
        }
    }

    protected boolean envoieMsg (String serveur, int port, String data) {
        try {
            return envoieMsg(InetAddress.getByName(serveur),port,data);
        } catch (UnknownHostException e) {
            error("Erreur le nom du serveur est non valide : " + e );
            return false;
        }
    }

    private void error(String message) {
        System.err.println("Erreur sur" + this +
                ":\n" + message);
    }

    @Override
    public String toString() {
        return "addresse = " + addrA + ", port = " + portA ;
    }
}
