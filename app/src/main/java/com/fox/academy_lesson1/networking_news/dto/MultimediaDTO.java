package com.fox.academy_lesson1.networking_news.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fox on 05.11.18.
 */

public class MultimediaDTO {
    @SerializedName("url")
    String newsImageUrl;
    String format;
    double height;
    double width;
    String type;
    String subtype;
    String caption;
    String copyright;


    public String getNewsImageUrl() {
        return newsImageUrl;
    }
}
