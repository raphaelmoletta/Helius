package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
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

    private InputStream in;
    private boolean serialStop = false;

    public ThreadCommunication() {
    }

    public boolean isSerialEnable() {
        return false; //serialThread != null && serialThread.isAlive();
    }

    @Lock(LockType.READ)
    public boolean isUDPEnable() {
        return false;// udpThread != null && udpThread.isAlive();
    }

    public synchronized InputStream getInputStream() {
        return in;
    }

    public synchronized void setInputStream(InputStream in) {
        this.in = in;
    }

    @Lock(LockType.READ)
    public synchronized boolean getSerialStop() {
        return this.serialStop;
    }
    @Lock(LockType.WRITE)
    public synchronized void setSerialStop(boolean serialStop) {
        this.serialStop = serialStop;
    }
}
