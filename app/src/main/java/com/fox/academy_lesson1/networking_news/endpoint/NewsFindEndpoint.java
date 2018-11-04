package com.fox.academy_lesson1.networking_news.endpoint;

import android.support.annotation.NonNull;

import com.fox.academy_lesson1.networking_news.DefaultResponse;
import com.fox.academy_lesson1.networking_news.dto.NewsDTO;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface NewsFindEndpoint {
        @NonNull
        @GET("technology.json")
        Call<DefaultResponse<List<NewsDTO>>> search(@Query("q") @NonNull String search);
    }

