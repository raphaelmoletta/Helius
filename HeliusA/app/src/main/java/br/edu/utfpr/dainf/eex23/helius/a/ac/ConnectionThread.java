package br.edu.utfpr.dainf.eex23.helius.a.ac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.edu.utfpr.dainf.eex23.helius.a.beans.DTO;

/**
 * @author Raphael Zagonel Moletta <raphael@alunos.utfpr.edu.br>
 */

public class ConnectionThread implements Runnable {
    private DTO DTO;

    public ConnectionThread(DTO DTO) {
        this.DTO = DTO;
    }

    @Override
    public void run() {
        try {
            URL u = new URL(Util.path.concat(DTO.getUrl()));

            HttpURLConnection com = (HttpURLConnection) u.openConnection();
            com.setRequestMethod("GET");
            int r = com.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(com.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            DTO.setStatus(DTO.STATUS.OK);
            DTO.setData(new String(response));
        } catch (Exception e) {
            DTO.setStatus(DTO.STATUS.ERROR);
            DTO.setData(e.getLocalizedMessage());
        }
    }
}
