package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.HeliusEJB;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Raphael Zagonel Moletta <raphael.moletta@gmail.com>
 */
@ManagedBean(name = "configurations")
@SessionScoped
public class ConfigurationsMB implements Serializable {
    private static final long serialVersionUID = 4966650781932239884L;
    
    private boolean udpEnabled = false, serialEnabled = false;
    private int udpPort = 0;
    private String serialPort = "";
    private List<String> serialPorts;

    public boolean isUdpEnabled() {
        HeliusEJB.configuration.isUdpEnabled();
        return udpEnabled;
    }

    public void setUdpEnabled(boolean udpEnabled) {
        this.udpEnabled = HeliusEJB.configuration.setUdpEnabled(udpEnabled);
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public boolean isSerialEnabled() {
        this.serialEnabled = this.serialEnabled = HeliusEJB.configuration.getSerialEnable();
        return serialEnabled;
    }

    public void setSerialEnabled(boolean serialEnabled) {
        this.serialEnabled = HeliusEJB.configuration.setSerialEnable(serialEnabled);
    }

    public String getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(String serialPort) {
        this.serialPort = serialPort;
        HeliusEJB.configuration.setSerialPort(serialPort);
    }

    public List<String> getSerialPorts() {
        this.serialPorts = HeliusEJB.configuration.getSerialPorts();
        return this.serialPorts;
    }

    public void setSerialPorts(List<String> serialPorts) {
        //Leave Blank
    }
    
    public void handleFileUpload (FileUploadEvent event) {
        try {
            HeliusEJB.configuration.upload(event.getFile().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationsMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
