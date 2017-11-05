package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.HeliusEJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
@Named(value = "status")
@SessionScoped
public class StatusMB implements Serializable {

    private final static String CHECK = "check", FAIL = "closethick";
    private static final long serialVersionUID = 4381838349461144783L;
    private String server = CHECK, udp = FAIL, serial = FAIL, db = FAIL;

    public String getServer() {
        this.server = HeliusEJB.status.getServerStatus() ? CHECK : FAIL;
        return server;
    }

    public String getUdp() {
        this.udp = HeliusEJB.status.getServerUDP() ? CHECK : FAIL;
        return udp;
    }

    public String getSerial() {
        this.serial = HeliusEJB.status.getServerSerial() ? CHECK : FAIL;
        return serial;
    }

    public String getDb() {
        this.db = HeliusEJB.status.getServerDB() ? CHECK : FAIL;
        return db;
    }
}
