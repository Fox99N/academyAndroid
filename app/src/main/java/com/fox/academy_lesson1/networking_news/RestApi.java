package com.fox.academy_lesson1.networking_news;

import android.support.annotation.NonNull;

import com.fox.academy_lesson1.networking_news.endpoint.NewsFindEndpoint;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {
    private static final String URL = "https://api.nytimes.com/svc/topstories/v2/";
    private static final String API_KEY = "b7844dbb0d25468bbc52ecadc6e59ef4";
    private static final int TIMEOUT_IN_SECONDS = 2;
    private static RestApi restApi;
    private static NewsFindEndpoint newsFindEndpoint;

    public static synchronized RestApi getInstance() {
        if (restApi == null) {
            restApi = new RestApi();
        }
        return restApi;
    }

    private RestApi() {
        final OkHttpClient httpClient = buildOkHttpClient();
        final Retrofit retrofit = buildRetrofitClient(httpClient);
        newsFindEndpoint = retrofit.create(NewsFindEndpoint.class);
    }

    private Retrofit buildRetrofitClient(@NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient buildOkHttpClient() {
        final HttpLoggingInterceptor networkLogInterceptor = new HttpLoggingInterceptor();
        networkLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original=  chain.request();

                        Request.Builder builder = original.newBuilder()
                                .header("Authorization", API_KEY);
                        Request  request = builder.build();
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .build();

    }


}
