package br.edu.utfpr.dainf.eex23.helius.bs.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;

/**
 *
 * @author Raphael Zagonel Moletta
 */
@Stateless
@LocalBean
public class NewSessionBean {

    @PostActivate
    public void postActivate() {
        
    }
    
    @PrePassivate
    public void prePassivate() {
        
    }
    
    public void businessMethod() {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
