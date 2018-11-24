package com.fox.academy_lesson1.ex6_persistance;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "news")
public class NewsEntity {
    @PrimaryKey
    @NonNull
    private int id;
    @ColumnInfo(name = "section")
    private String section;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "abstractDescription")
    private String abstractDescription;

    @ColumnInfo(name = "publishDate")
    private String publishDate;

    @ColumnInfo(name = "url")
    private String url;

    public NewsEntity() {
    }

    public NewsEntity(@NonNull int id, String section, String title, String author, String abstractDescription, String publishDate, String url) {
        this.id = id;
        this.section = section;
        this.title = title;
        this.author = author;
        this.abstractDescription = abstractDescription;
        this.publishDate = publishDate;
        this.url = url;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAbstractDescription(String abstractDescription) {
        this.abstractDescription = abstractDescription;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "id=" + id +
                ", section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", abstractDescription='" + abstractDescription + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}