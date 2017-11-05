package br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class StartEJB {

    public List<String> embeddedSystemsSending() {
        List<String> servers = new ArrayList<>();
        servers.add("NI myRIO");
        return servers;
    }

    public String packagesTraffic() {
        return "60";
    }
    
}
