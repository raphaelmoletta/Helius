/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dainf.eex23.helius.beans.exceptions;

/**
 *
 * @author Raphael Zagonel Moletta <raphael.moletta@gmail.com>
 */
public class ThreadIsAliveException extends Exception {

    private static final long serialVersionUID = -5956798642082279163L;

    /**
     * Creates a new instance of <code>ThreadIsAliveException</code> without
     * detail message.
     */
    public ThreadIsAliveException() {
    }

    /**
     * Constructs an instance of <code>ThreadIsAliveException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ThreadIsAliveException(String msg) {
        super(msg);
    }
}
