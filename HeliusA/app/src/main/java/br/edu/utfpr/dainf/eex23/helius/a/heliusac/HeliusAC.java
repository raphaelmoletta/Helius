package br.edu.utfpr.dainf.eex23.helius.a.heliusac;

import br.edu.utfpr.dainf.eex23.helius.a.beans.GraphData;

/**
 * @author rapha
 */
public class HeliusAC {
    public static GraphData getVoltages(TIME time) {
        return ComunicacaoWebService.getGraphData(time, TYPE.tensao);

    }

    ;

    public static GraphData getCurrents(TIME time) {
        return ComunicacaoWebService.getGraphData(time, TYPE.corrente);
    }

    ;

    public static GraphData getEfficiency(TIME time) {
        return ComunicacaoWebService.getGraphData(time, TYPE.eficiencia);
    }

    public static GraphData getEconomies(TIME time) {
        return ComunicacaoWebService.getGraphData(time, TYPE.economia);
    }

    public static double getEfficiency() {
        return ComunicacaoWebService.getHomeData().getEficiencia();
    }

    public static double getTemperature() {
        return ComunicacaoWebService.getHomeData().getTemperatura();
    }

    public static double getIrradiance() {
        return ComunicacaoWebService.getHomeData().getIncidencia();
    }

    public static double getEconomy() {
        return ComunicacaoWebService.getHomeData().getEconomia();
    }

    public enum TIME {day, week, month, year}

    public enum TYPE {corrente, tensao, eficiencia, economia}


}


