package com.fox.academy_lesson1.ex6_persistance;


import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class NewsViewModal  extends AndroidViewModel {
    private NewsRepository newsRepository;
    private LiveData<List<NewsEntity>> newsEntity;

    public NewsViewModal(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository(application);
        newsEntity = newsRepository.getDataObservable();
    }

    public void insert(NewsEntity newsEntity){
        newsRepository.insert(newsEntity);
    }
}
