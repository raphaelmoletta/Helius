package br.edu.utfpr.dainf.eex23.helius.a.ac;

import java.util.Calendar;
import java.util.Date;

import br.edu.utfpr.dainf.eex23.helius.a.beans.DTO;

/**
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class HeliusAC {
    public enum TIME {day, week, month, year}
    public enum TYPE {current, voltage, efficiency, economy}

    protected static HeliusAC heliusAC = null;

    protected HeliusAC() {}

    protected DTO dataHome = null;
    protected DTO dataGraph = null;
    protected Date ldtDataHome = null;

    protected TYPE typeGraph;

    private DTO getHomeDataNonStatic() {
        Calendar ldt = (Calendar) Calendar.getInstance().clone();
        ldt.add(Calendar.MINUTE,-1);
        if (ldtDataHome == null || dataHome == null) {
            getInstance().ldtDataHome = Calendar.getInstance().getTime();
            getInstance().dataHome = WebServiceConnection.getHomeData();
        } else if (ldtDataHome.after(ldt.getTime()) || getHomeData().getStatus() != DTO.STATUS.OK) {
            getInstance().ldtDataHome = Calendar.getInstance().getTime();
            getInstance().dataHome = WebServiceConnection.getHomeData();
        }
        return getInstance().dataHome;
    }

    private static HeliusAC getInstance() {
        if (HeliusAC.heliusAC == null) {
            HeliusAC.heliusAC = new HeliusAC();
        }
        return heliusAC;
    }
    public static DTO getHomeData() {
        return getInstance().getHomeDataNonStatic();
    }

    public static DTO getGraphData(TIME time) {
        return WebServiceConnection.getGraphData(time, HeliusAC.getInstance().typeGraph);
    }

    public static void setGraph(TYPE typeGraph) {
        HeliusAC.getInstance().typeGraph = typeGraph;
    }
}