package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import gnu.io.CommPortIdentifier;
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

    public static void startSerial(String port) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
        if (threadUDP == null) {
            threadUDP = thread;
        } else {

        }

    }

    executor.execute (thread);
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
}
