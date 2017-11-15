package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ejb.Singleton;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
@Singleton
public class ThreadPool {

    private ThreadCommunication threadCommunication = null;
    private Thread threadUDP = null;
    private SerialListener serialListener;
    private static ThreadPool tp = null;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void setSerialPort(String serialPort) {

    }

    public boolean stopSerial() {
        System.out.println("Stop serial");
        return serialListener.close();
    }

    public boolean startUDP(int udpPort) {
        return false;
    }

    public boolean stopUDP() {
        return false;
    }

    public enum TYPE {
        UDP, Serial, SQL
    };

    protected ThreadPool() {

    }

    public static synchronized ThreadPool getInstance() {
        if (tp == null) {
            tp = new ThreadPool();
        }
        return tp;
    }

    private ThreadCommunication getTC() {
        if (threadCommunication == null) {
            threadCommunication = new ThreadCommunication();
        }
        return threadCommunication;
    }

    public boolean startSerial(String port) {
        System.out.println("Start serial: " + port);
        serialListener = new SerialListener();
        
        return serialListener.initialize(port, getTC());
        /*
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
            if (portIdentifier.isCurrentlyOwned()) {
                System.err.println("Error: Port is currently in use: " + portIdentifier.getCurrentOwner());
                return false;
            } else {
                CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

                if (commPort instanceof SerialPort) {
                    SerialPort serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    BufferedReader br = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                    //getTC().setBufferedReader(in);
                    threadSerial = new SerialThread(getTC());
                    threadSerial.start();
                    return true;
                }
            }
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException e) {
            Logger.getLogger(ThreadCommunication.class.getName()).log(Level.SEVERE, null, e);
        }*/
    }
}
/*
  case Serial:
                if (threadSerial == null) {
                    threadSerial = thread;
                } else {
                    if(threadSerial.isAlive()) {
                        throw new ThreadIsAliveException("Attempt start Serial thread, this thread was already start.");
                    } else {
                        threadSerial.interrupt();
                    }
                }
                break;
            case SQL:
                //Leaved blank
 */
