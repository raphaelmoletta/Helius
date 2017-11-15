/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;

/**
 *
 * @author Raphael Zagonel Moletta <raphael.moletta@gmail.com>
 */
public class SerialListener implements SerialPortEventListener {

    private InputStream input;
    private SerialPort serialPort;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    private ThreadCommunication tc;

    public boolean initialize(String port, ThreadCommunication tc) {
        try {
            this.tc = tc;
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(port);

            if (portId == null) {
                System.out.println("Could not find COM port.");
                return false;
            }

            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_XONXOFF_IN | SerialPort.FLOWCONTROL_XONXOFF_OUT);
            serialPort.setRTS(true);

            // open the streams
            input = serialPort.getInputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            return true;
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
        }
        return false;
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     *
     * @return
     */
    public synchronized boolean close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
            return true;
        }
        return false;
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                while (oEvent.getEventType() != SerialPortEvent.DATA_AVAILABLE) {
                }
                byte buffer[] = new byte[2048];
                int len = input.read(buffer);
                System.out.print(new String(buffer, 0, len));

            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

}
