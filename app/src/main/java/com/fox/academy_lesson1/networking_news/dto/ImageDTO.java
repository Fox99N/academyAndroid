package com.fox.academy_lesson1.networking_news.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by fox on 04.11.18.
 */

public class ImageDTO {
    @SerializedName("multimedia")
    ArrayList<Object> newMultiData;

    public ArrayList<Object> getNewMultiData() {
        return newMultiData;
    }
}
