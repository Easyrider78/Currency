package Curren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Curren {

    String BASEURL = "https://api.exchangeratesapi.io";

    public String getCurr(String x, String y, String z) throws IOException {
        String path = "/" + x + "?symbols=" + y + "&base=" + z;
        String request = getJson("GET", path);

        return request;
    }

    public String getJson(String reqMetod, String path) throws IOException {
        String apiUrl = BASEURL + path;
        String json = null;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int code = con.getResponseCode();
            if (code == 200) {

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                br.close();


                return sb.toString();
            } else {
                System.out.println("Ответ сервера: " + code);
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}


