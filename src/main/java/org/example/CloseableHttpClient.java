package org.example;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;

public class CloseableHttpClient {
    CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                    .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                    .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                    .build())
            .build();
}
