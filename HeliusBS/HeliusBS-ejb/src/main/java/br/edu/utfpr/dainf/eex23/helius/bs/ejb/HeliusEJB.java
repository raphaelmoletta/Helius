package br.edu.utfpr.dainf.eex23.helius.bs.ejb;

import br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci.ConfigurationsEJB;
import br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci.StartEJB;
import br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci.StatusEJB;

/**
 *
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class HeliusEJB {
    public static StartEJB start = new StartEJB();
    public static StatusEJB status = new StatusEJB();
    public static ConfigurationsEJB configuration = new ConfigurationsEJB();
    
}
