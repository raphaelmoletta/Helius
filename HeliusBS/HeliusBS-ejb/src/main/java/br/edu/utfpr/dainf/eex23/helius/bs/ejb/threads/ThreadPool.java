package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class ThreadPool {
    
    private ThreadCommunication threadCommunication = null;
    private Thread threadUDP = null, threadSerial = null;
    private SerialListener serialListener;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private static ThreadPool tp;
    
    private ThreadPool() {
        threadCommunication = new ThreadCommunication();
    }
    
    public static ThreadPool getInstance() {
        if(tp == null) {
            tp = new ThreadPool();
        }
        return tp;
    }
    
    public boolean startSerial(String port) {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
            if (portIdentifier.isCurrentlyOwned()) {
                System.out.println("Error: Port is currently in use");
            } else {
                CommPort commPort = portIdentifier.open(ThreadPool.class.getName(), 2000);
                
                if (commPort instanceof SerialPort) {
                    SerialPort serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    
                    threadCommunication.setInputStream(serialPort.getInputStream());
                    //OutputStream out = serialPort.getOutputStream();

                    threadSerial = new SerialReaderThread(threadCommunication);
                    executor.execute(threadSerial);
                    return true;
                } else {
                    System.out.println("Error: Only serial ports are handled by this example.");
                }
            }
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException e) {
            System.out.println("Erro");
        }
        return false;
    }
    
    public boolean startUDP(int port) {
        //if (threadUDP == null) {
            threadCommunication.setUDPStop(false);
            threadCommunication.initSocket(port);
            threadUDP = new Thread(new UDPThread(threadCommunication), "Helius UDP Thread");
            threadUDP.start();
            return true;
        //}
        //return false;
    }
    
    public boolean stopUDP() {
        threadCommunication.setUDPStop(true);
        threadCommunication.getSocket().close();
        return false;
    }
    
    public boolean stopSerial() {
        return false;
    }
    
    public boolean getServerUDPStatus() {
        return threadUDP != null && threadUDP.isAlive();
    }

    public boolean getServerSerialStatus() {
        return threadSerial != null && threadSerial.isAlive();
    }

    public boolean getServerSQLStatus() {
        return false;
    }
}