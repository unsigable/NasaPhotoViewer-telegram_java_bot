package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class Utils {
    public static String getUrl(String nasaUrl) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(nasaUrl);
        ObjectMapper mapper = new ObjectMapper();

        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);
            return answer.url;
        } catch (IOException e) {
            System.out.println("Ошибка доступа к серверу NASA");
            return "";
        }
    }

    public static String getName(String nasaUrl) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(nasaUrl);
        ObjectMapper mapper = new ObjectMapper();

        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);
            return answer.title;
        } catch (IOException e) {
            System.out.println("Ошибка доступа к серверу NASA");
            return "";
        }
    }


}
