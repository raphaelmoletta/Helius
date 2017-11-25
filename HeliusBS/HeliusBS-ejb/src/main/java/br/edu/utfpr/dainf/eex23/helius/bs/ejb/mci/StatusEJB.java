package br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.threads.ThreadPool;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class StatusEJB {

    public boolean getServerDB() {
        return ThreadPool.getInstance().getServerSQLStatus();
    }

    public boolean getServerSerial() {
        return ThreadPool.getInstance().getServerSerialStatus();
    }

    public boolean getServerUDP() {
        return ThreadPool.getInstance().getServerUDPStatus();
    }

    public boolean getServerStatus() {
        return true;
    }
    
}
