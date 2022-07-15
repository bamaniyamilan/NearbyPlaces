package com.example.nearbyplaces;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class APIClient {
    private static Retrofit retrofit = null;
    public static final String GOOGLE_PLACE_API_KEY = "ADD_YOUR_API_KEY_HERE";
    public static String BASE_URL = "https://maps.googleapis.com/maps/api/";

    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).
                writeTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        retrofit = null;

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build();
        return retrofit;
    }
}
