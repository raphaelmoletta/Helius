package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import br.edu.utfpr.dainf.eex23.helius.beans.Data;
import br.edu.utfpr.dainf.eex23.helius.bs.data.HeliusData;
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
        Data d;
        String txt;
        while (!tc.isUDPStop()) {
            try {
                tc.getSocket().receive(packet);
                txt = new String(packet.getData());
                System.out.println("txt: " + txt);
                d = get(txt);
                HeliusData.getInstance().add(d);
            } catch (SocketException ex) {
                System.out.println("Closing...");
            } catch (IOException ex) {
                Logger.getLogger(UDPThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Data get(String value) {
        Data d = new Data();
        try {
            int begin = value.indexOf("id\":") + 4;
            int end = value.indexOf(",", begin);
            String sid = value.substring(begin, end).trim().replaceAll("\"", "");
            d.setId(sid);
            
            begin = value.indexOf("c\":") + 3;
            end = value.indexOf(",", begin);
            sid = value.substring(begin, end).trim();
            d.setCurrent(Double.parseDouble(sid));
            
            begin = value.indexOf("i\":") + 3;
            end = value.indexOf(",", begin);
            sid = value.substring(begin, end).trim();
            d.setIrradiance(Double.parseDouble(sid));
            
            begin = value.indexOf("t\":") + 3;
            end = value.indexOf(",", begin);
            sid = value.substring(begin, end).trim();
            d.setTemperature(Double.parseDouble(sid));
            
            begin = value.indexOf("v\":") + 3;
            end = value.indexOf(",", begin);
            sid = value.substring(begin, end).trim();
            d.setVoltage(Double.parseDouble(sid));
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            return d;
        }
        return d;
    }
}