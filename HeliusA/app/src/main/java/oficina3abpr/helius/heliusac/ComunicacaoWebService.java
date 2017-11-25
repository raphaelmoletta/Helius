package oficina3abpr.helius.heliusac;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

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
            lastDate = new Date();
            String resposta = getURL("/home");
            Gson gson = new Gson();
            return (HomeData) gson.fromJson(resposta, HomeData.class);
        }

        return null;

    }

    private static String getURL(String url){

        try{
            URL u= new URL(Util.path.concat(url));



            HttpsURLConnection com= (HttpsURLConnection)u.openConnection();
            com.setRequestMethod("GET");
            int r= com.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(com.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            return response.toString();
        }

        catch (Exception e){


        }

       return "";

    }

    public static GraphData getGraphData(HeliusAC.TIME time, HeliusAC.TYPE type) {

        String resposta= "";

        switch (type) {
            case corrente:
                resposta = getURL("/corrente");

                break;
            case tensao:
                resposta= getURL("/tensao");
                break;
            case eficiencia:
               resposta= getURL("/eficiencia");
                break;
            case economia:
               resposta = getURL("/economia");
                break;
        }

        Gson gson= new Gson();
        gson.fromJson(resposta, GraphData.class);

    return (GraphData)gson.fromJson(resposta, GraphData.class);
    }

}