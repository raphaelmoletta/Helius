package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.HeliusEJB;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
@Named(value = "configurations")
@SessionScoped
public class ConfigurationsMB implements Serializable {

    private static final long serialVersionUID = 4966650781932239884L;

    private boolean udpEnabled = false, serialEnabled = false;
    private int udpPort = 11000;
    private String serialPort = "ttyACM0", driver = "com.mysql.jdbc.Driver",
            connectionPath = "jdbc:mysql://localhost:3306/heliusdb",
            username = "root", password = "Pipeline00";
    private List<String> serialPorts;

    public boolean isUdpEnabled() {
        return udpEnabled;
    }

    public void setUdpEnabled(boolean udpEnabled) {
        if (udpEnabled) {
            boolean b = HeliusEJB.configuration.setDB(driver, connectionPath, username, password);
            HeliusEJB.configuration.startDB(connectionPath, driver, username, password);
            this.udpEnabled = HeliusEJB.configuration.startUDP(udpPort);
        } else {
            this.udpEnabled = HeliusEJB.configuration.stopUDP();
        }
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public boolean isSerialEnabled() {
        return false;
        //return serialEnabled;
    }

    public void setSerialEnabled(boolean serialEnabled) {
        if (serialEnabled) {
            this.serialEnabled = HeliusEJB.configuration.startSerial("/dev/ttyACM0");
        } else {
            this.serialEnabled = HeliusEJB.configuration.stopSerial();
        }
    }

    public String getSerialPort() {
        return serialPort;
    }

    public void setSerialPort(String serialPort) {
        this.serialPort = serialPort;
    }

    public List<String> getSerialPorts() {
        this.serialPorts = HeliusEJB.configuration.getSerialPorts();
        return this.serialPorts;
    }

    public void setSerialPorts(List<String> serialPorts) {
        //Leave Blank
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            HeliusEJB.configuration.upload(event.getFile().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ConfigurationsMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getConnectionPath() {
        return connectionPath;
    }

    public void setConnectionPath(String connectionPath) {
        this.connectionPath = connectionPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
