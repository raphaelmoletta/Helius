package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class SerialThread extends Thread {

    private final ThreadCommunication tc;

    public SerialThread(ThreadCommunication tc) {
        this.tc = tc;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int len;
        InputStream in = null;
        try {
            while ((len = in.read(buffer)) > -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            System.err.print("Serial Port: IOException: " + e.toString());
        }
    }
}
