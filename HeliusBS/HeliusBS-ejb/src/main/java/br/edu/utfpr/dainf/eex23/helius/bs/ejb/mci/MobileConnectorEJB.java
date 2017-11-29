package br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci;

import br.edu.utfpr.dainf.eex23.helius.beans.HomeData;
import com.google.gson.Gson;

/**
 *
 * @author rapha
 */
public class MobileConnectorEJB {
    public String getHome() {
        Gson g = new Gson();
        HomeData h = new HomeData(2.5, 2.6, 2.7, 2.8);
        return g.toJson(h,HomeData.class);
    }
}
