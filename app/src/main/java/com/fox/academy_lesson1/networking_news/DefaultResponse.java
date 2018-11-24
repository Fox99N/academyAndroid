package com.fox.academy_lesson1.networking_news;
import androidx.annotation.Nullable;



public class DefaultResponse<T> {

    private T data;

    @Nullable
    public T getData() {
        return data;
    }
}