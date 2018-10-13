package com.fox.academy_lesson1.NewListEx;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * Created by fox on 07.10.18.
 */

public class NewsItem {

    private final String author;
    private final Drawable imageUrl;
    private final String category;
    private final Date publishDate;
    private final String previewText;
    private final String fullText;

    public NewsItem(String author, Drawable imageUrl, String category, Date publishDate, String previewText, String fullText) {
        this.author = author;
        this.imageUrl = imageUrl;
        this.category = category;
        this.publishDate = publishDate;
        this.previewText = previewText;
        this.fullText = fullText;
    }

    public String getAuthor() {
        return author;
    }

    public Drawable getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getFullText() {
        return fullText;
    }



}

