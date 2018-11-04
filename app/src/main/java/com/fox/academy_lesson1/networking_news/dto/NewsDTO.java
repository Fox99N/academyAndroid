package com.fox.academy_lesson1.networking_news.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fox on 04.11.18.
 */

public class NewsDTO {
     @SerializedName("section")
    String section;
     @SerializedName("title")
    String title;
     @SerializedName("abstract")
    String abstractDescription;
     @SerializedName("published_date")
    String publishDate;
     @SerializedName("url")
    String url;

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractDescription() {
        return abstractDescription;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getUrl() {
        return url;
    }
}
