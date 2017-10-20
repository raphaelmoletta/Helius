package br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael Zagonel Moletta <raphael.moletta@gmail.com>
 */
public class ConfigurationsEJB {

    public void upload(InputStream inputstream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<String> getSerialPorts() {
        List<String> serialPorts = new ArrayList<>();
        serialPorts.add("COM1");
        serialPorts.add("COM2");
        serialPorts.add("COM3");
        serialPorts.add("COM4");
        return serialPorts;
    }

    public void setSerialPort(String serialPort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setSerialEnable(boolean serialEnabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getSerialEnable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void isUdpEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean setUdpEnabled(boolean udpEnabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
