package com.fox.academy_lesson1.networking_news.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class ResultDTO implements Serializable{
    @SerializedName("section")
    String section;
    @SerializedName("title")
    String title;
    @SerializedName("byline")
    String author;
    @SerializedName("abstract")
    String abstractDescription;
    @SerializedName("published_date")
    String publishDate;
    @SerializedName("url")
    String url;
    @SerializedName("multimedia")
    List<MultimediaDTO> multimedia;

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
        return url;}

    public List<MultimediaDTO> getMultimedia() {
        return multimedia;
    }

    public String getAuthor() {
        return author;
    }

}
