package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import java.io.IOException;

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
        System.out.println("Start Thread");
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = tc.getInputStream().read(buffer)) > -1 && !tc.getSerialStop()) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            System.err.print("Serial Port: IOException: " + e.toString());
        }
        System.out.println("End Thread");
    }
}
