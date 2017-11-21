package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rapha
 */
public class UDPThread implements Runnable {

    private ThreadCommunication tc;
    private int port;

    public UDPThread(ThreadCommunication tc) {
        this.tc = tc;
    }

    @Override
    public void run() {
        final int Size = 2048;
        byte data[] = new byte[Size];
        DatagramPacket packet = new DatagramPacket(data, Size);
        while(!tc.isUDPStop()){
            try {
                tc.getSocket().receive(packet);
                System.out.println("Packet: " + new String(packet.getData()));
            } catch (SocketException ex) {
                System.out.println("Closing...");
            } catch (IOException ex) {
                Logger.getLogger(UDPThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
