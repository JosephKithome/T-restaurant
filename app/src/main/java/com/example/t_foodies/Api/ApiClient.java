package com.example.t_foodies.Api;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiClient {

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://themealdb.p.rapidapi.com/filter.php?i=chicken_breast")
            .get()
            .addHeader("x-rapidapi-key", "ba370b185emshf90f09df12ec9b3p13a4ecjsna0de6ed73323")
            .addHeader("x-rapidapi-host", "themealdb.p.rapidapi.com")
            .build();

    Response response = client.newCall(request).execute();

    public ApiClient() throws IOException {
    }
}
