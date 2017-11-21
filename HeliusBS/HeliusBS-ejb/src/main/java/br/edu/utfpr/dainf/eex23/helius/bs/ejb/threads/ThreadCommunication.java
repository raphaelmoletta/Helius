package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import java.io.InputStream;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Startup
public class ThreadCommunication {

    private InputStream inputStream;
    private boolean serialStop = false, udpStop = false;
    private InetAddress address;
    private DatagramSocket socket;

    public ThreadCommunication() {
    }

    @Lock(LockType.WRITE)
    public synchronized boolean initSocket(int port) {
        try {
            this.address = Inet4Address.getByName("0.0.0.0");
            this.socket = new DatagramSocket(port, address);
            this.socket.setBroadcast(true);
            return true;
        } catch (UnknownHostException | SocketException e) {
            Logger.getLogger(ThreadCommunication.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Lock(LockType.READ)
    public synchronized InputStream getInputStream() {
        return inputStream;
    }

    @Lock(LockType.WRITE)
    public synchronized void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Lock(LockType.READ)
    public synchronized DatagramSocket getSocket() {
        return socket;
    }
    
    @Lock(LockType.WRITE)
    public synchronized void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    @Lock(LockType.READ)
    public synchronized boolean isUDPStop() {
        return udpStop;
    }
    @Lock(LockType.WRITE)
    public synchronized void setUDPStop (boolean stopUDP) {
        this.udpStop = stopUDP;
    }    
}
