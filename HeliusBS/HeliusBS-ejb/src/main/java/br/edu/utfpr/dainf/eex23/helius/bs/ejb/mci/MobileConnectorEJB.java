package br.edu.utfpr.dainf.eex23.helius.bs.ejb.mci;

import br.edu.utfpr.dainf.eex23.helius.beans.GraphsCollection;
import br.edu.utfpr.dainf.eex23.helius.beans.HomeData;
import br.edu.utfpr.dainf.eex23.helius.bs.data.HeliusData;
import com.google.gson.Gson;

/**
 *
 * @author rapha
 */
public class MobileConnectorEJB {
    private Gson gson = new Gson();
    public String getHome() {
        return gson.toJson(HeliusData.getInstance().getHome(),HomeData.class);
    }

    public String getGraphCurrent() {        
        GraphsCollection gd = HeliusData.getInstance().getGraphCurrent();
        return gson.toJson(gd, GraphsCollection.class);
    }

    public String getGraphVoltage() {
        GraphsCollection gd = HeliusData.getInstance().getGraphsVoltage();
        return gson.toJson(gd, GraphsCollection.class);
    }

    public String getGraphEfficiency() {
        GraphsCollection gd = HeliusData.getInstance().getGraphsEfficiency();
        return gson.toJson(gd, GraphsCollection.class);
    }

    public String getGraphEconomy() {
        GraphsCollection gd = HeliusData.getInstance().getGraphsEconomy();
        return gson.toJson(gd, GraphsCollection.class);
    }
}
