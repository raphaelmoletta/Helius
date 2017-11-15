package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import java.io.InputStream;
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

    public ThreadCommunication() {
    }

    /*
    @Lock(LockType.READ)
    public boolean isSerialEnable() {
        return false; //serialThread != null && serialThread.isAlive();
    }

    @Lock(LockType.READ)
    public boolean isUDPEnable() {
        return false;// udpThread != null && udpThread.isAlive();
    }
/*
    public boolean initSerial(String port) {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
            if (portIdentifier.isCurrentlyOwned()) {
                System.err.println("Error: Port is currently in use: " + portIdentifier.getCurrentOwner());
                return false;
            } else {
                CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

                if (commPort instanceof SerialPort) {
                    SerialPort serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    return true;
                }
            }
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException e) {
        }
        return false;
    }
     */
    @Lock(LockType.READ)
    public InputStream getInputStream() {
        return inputStream;
    }

    @Lock(LockType.WRITE)
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
