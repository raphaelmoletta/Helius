package br.edu.utfpr.dainf.eex23.helius.a.ac;

import br.edu.utfpr.dainf.eex23.helius.a.beans.DTO;

/**
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */
public class WebServiceConnection{
    public static DTO getHomeData() {
        return getURL("/home");
    }

    private static DTO getURL(String url) {
        DTO DTO = new DTO();
        try {
            DTO.setUrl(url);
            ConnectionThread c = new ConnectionThread(DTO);
            Thread t = new Thread(c);
            t.join();
            t.start();
            while(t.isAlive()) {}
            return DTO;
        } catch (Exception e) {
            System.out.println(e.toString());
            DTO.setStatus(DTO.STATUS.ERROR);
            DTO.setData(e.getLocalizedMessage());
            return DTO;
        }
    }

    public static DTO getGraphData(HeliusAC.TIME time, HeliusAC.TYPE type) {
        switch (type) {
            case current:
                return getURL("/cu?".concat(time.name()));
            case voltage:
                return getURL("/vo?".concat(time.name()));
            case efficiency:
                return getURL("/ef?".concat(time.name()));
            case economy:
                return getURL("/ec?".concat(time.name()));
        }
        return null;
    }
}