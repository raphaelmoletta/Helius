package br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads.ThreadPool;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class ConfigurationsEJB {

    public void upload(InputStream inputstream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> getSerialPorts() {
        List<String> serialPorts = new ArrayList<>();
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier com = (CommPortIdentifier) ports.nextElement();
            switch (com.getPortType()) {
                case CommPortIdentifier.PORT_SERIAL:
                    try {
                        CommPort thePort = com.open("CommUtil", 50);
                        thePort.close();
                        serialPorts.add(com.getName());
                    } catch (PortInUseException e) {
                        System.out.println("Port, " + com.getName() + ", is in use.");
                    } catch (Exception e) {
                        System.err.println("Failed to open port " + com.getName());
                    }
            }
        }
        if (serialPorts.isEmpty()) {
            serialPorts.add("NA");
        }
        return serialPorts;
    }

    public boolean startSerial(String serialPort) {
        System.out.println("Serial port: " + serialPort);
        return ThreadPool.getInstance().startSerial(serialPort);
    }

    public boolean stopSerial() {
        return ThreadPool.getInstance().stopSerial();
    }

    public boolean startUDP(int udpPort) {
        System.out.println("UDP Port: " + udpPort);
        return ThreadPool.getInstance().startUDP(udpPort);
    }
    
    public boolean stopUDP() {
        return ThreadPool.getInstance().stopUDP();
    }
}