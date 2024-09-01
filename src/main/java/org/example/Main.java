package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://api.nasa.gov/planetary/apod?api_key=wKiOhrlLDXymnNT52eS9dJi8HuikNzVqYLuY5oF6&date=2024-08-31";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);

/*
       Scanner scanner = new Scanner(response.getEntity().getContent());
       String imageInfo = scanner.nextLine();
       System.out.println(imageInfo);
*/

        ObjectMapper mapper = new ObjectMapper();
        NasaAnswer answer = mapper.readValue(response.getEntity().getContent(), NasaAnswer.class);

        // System.out.println(answer.title);
        // System.out.println(answer.explanation);
         System.out.println(answer.url);

        String imageUrl = answer.url;
        String[] separetedUrl = imageUrl.split("/");
        String filename = separetedUrl[separetedUrl.length - 1];

        HttpGet imageRequest = new HttpGet(imageUrl);
        CloseableHttpResponse image = httpclient.execute(imageRequest);

        FileOutputStream fos = new FileOutputStream("images/" + filename);
        image.getEntity().writeTo(fos);

    }
}