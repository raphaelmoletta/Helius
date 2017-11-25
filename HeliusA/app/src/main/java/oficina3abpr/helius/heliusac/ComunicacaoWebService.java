package oficina3abpr.helius.heliusac;

import java.security.Timestamp;
import java.util.Date;

import oficina3abpr.helius.beans.DataPointHelius;
import oficina3abpr.helius.beans.GraphData;
import oficina3abpr.helius.beans.HomeData;

/**
 * Created by Dell on 15/11/2017.
 */
public class ComunicacaoWebService {

    public static HomeData dadosHome = new HomeData(82.9, 61.4, 27.6, 45.2);
    private static GraphData g = new GraphData();


    private static Date lastDate = new Date();

    public static HomeData getHomeData() {

        Date horaAtual = new Date();
        horaAtual.setTime(horaAtual.getTime() - 60000);
        if (horaAtual.after(lastDate)) {
            //// TODO: 15/11/2017
            //h= <do servidor> recebe do server
            lastDate = new Date();
        }

        //HomeData h= new HomeData(1.5, 2.5, 3.8, 4.0);
        return dadosHome;

    }

    public static GraphData getGraphData(HeliusAC.TIME time, HeliusAC.TYPE type) {

        switch (type) {
            case corrente:
                //TODO:
                break;
            case tensao:
                //TODO:
                break;
            case eficiencia:
                //TODO:
                break;
            case economia:
                //TODO:
                break;
        }

    return g;
    }

}