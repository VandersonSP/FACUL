package scheduler;

/**
 * Created by vande on 07/04/2016.
 */

import net.sf.corn.httpclient.HttpClient;
import net.sf.corn.httpclient.HttpResponse;

import java.net.URI;
import java.util.Arrays;

@org.springframework.stereotype.Service
public class Service {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URI = "https://twitter.com/search?l=&q=from%3ArealDonaldTrump&src=typd";

    public String get(HttpResponse responseInput) throws Exception {
        HttpClient client = new HttpClient(new URI(URI));
        HttpResponse response;
        if (responseInput == null) {
            response = client.sendData(HttpClient.HTTP_METHOD.GET);
        } else {
            response = responseInput;
        }
        String result = "";
        if (!response.hasError()) {
            int amountjpg = findAmountJpg(response.getData());
            if (amountjpg > 0) {
                if (amountjpg > 10) {
                    result = result + "Pagina Pesada";
                } else if (amountjpg > 5 && amountjpg <= 10) {
                    result = result + "Pagina um Pouco carregada";
                } else if (amountjpg > 2 && amountjpg <= 5) {
                    result = result + "Pagina Comum";
                } else {
                    result = result + "Pagina Basica";
                }
            } else {
                result = " Nenhuma imagem .jpg foi encontrada na pagina!";
            }

        } else {
            result = response.getMessage();
        }
        return result;
    }

    public int findAmountJpg(String txt) {
        int result = 0;
        String auxtxt = "";
        String txtOrig = txt;

        while (auxtxt.length() != txt.length()) {
            auxtxt= txt.toString();
            txt = removeJpg(txt);
        }

//        txt = txt.replace(".jpg", "");

        if (txtOrig.length() != txt.length()) {

            int var = txtOrig.length() - txt.length();

            result = var / 2;
        }

        return result;
    }

    private String removeJpg(String txt) {
        String[] var = txt.split(".jpg");
        String aux = Arrays.toString(var);
        return aux.substring(1,aux.length()-1);
    }
}



