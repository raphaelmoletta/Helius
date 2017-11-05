package br.edu.utfpr.dainf.eex23.helius.bs.web.managedbeans;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.HeliusEJB;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
@Named(value = "start")
@RequestScoped
public class StartMB implements Serializable {

    private static final long serialVersionUID = -7440566823847093182L;
    public String getPackagesTraffic() {
        return HeliusEJB.start.packagesTraffic();
    }

    public List<String> getEmbeddedSystemsSending() {
        return HeliusEJB.start.embeddedSystemsSending();
    }

}
