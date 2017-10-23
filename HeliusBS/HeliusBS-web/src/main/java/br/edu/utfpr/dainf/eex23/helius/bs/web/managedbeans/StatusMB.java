package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.HeliusEJB;
import javax.faces.bean.ManagedBean;

/** 
 *
 * @author Raphael Zagonel Moletta <raphael.moletta@gmail.com>
 */
@ManagedBean(name = "status")
public class StatusMB {
    private final String check = "check", fail = "closethick";
    private String server = check, udp = fail, serial = fail, db = fail;

    public String getServer() {
        this.server = HeliusEJB.status.getServerStatus() ? check : fail;
        return server;
    }

    public String getUdp() {
        this.udp = HeliusEJB.status.getServerUDP() ? check : fail;
        return udp;
    }

    public String getSerial() {
        this.serial = HeliusEJB.status.getServerSerial() ? check : fail;
        return serial;
    }

    public String getDb() {
        this.db = HeliusEJB.status.getServerDB() ? check : fail;
        return db;
    }
}
