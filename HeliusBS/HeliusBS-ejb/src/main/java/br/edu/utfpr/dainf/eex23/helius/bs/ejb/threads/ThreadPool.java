package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ejb.Singleton;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
@Singleton
public class ThreadPool {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public enum TYPE {
        UDP, Serial, SQL
    };
    private static Thread threadUDP = null, threadSerial = null;
    private static final ThreadCommunication TC = new ThreadCommunication();

    public static void startSerial(String port) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(ThreadPool.class.getName(), 2000);

            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                TC.setInputStream(serialPort.getInputStream());
                //OutputStream out = serialPort.getOutputStream();

                ThreadPool.threadSerial = new SerialReaderThread(TC);
                executor.execute(ThreadPool.threadSerial);

            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
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
