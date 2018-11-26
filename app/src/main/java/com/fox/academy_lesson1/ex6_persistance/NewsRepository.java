package com.fox.academy_lesson1.ex6_persistance;

import android.content.Context;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.Callable;


public class NewsRepository {
    private final Context context;

    public NewsRepository(Context cotext) {
        this.context = cotext;
    }
    Completable saveData(final List<NewsEntity> newsList) {
        return Completable.fromCallable(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                AppDatabase db = AppDatabase.getAppDatabase(context);
                NewsEntity[] news = newsList.toArray(new NewsEntity[newsList.size()]);
                db.newsDao().insertAll(news);
                return null;
            }
        });
    }

    Single<List<NewsEntity>> getData() {

        return Single.fromCallable(new Callable<List<NewsEntity>>() {
            @Override
            public List<NewsEntity> call() throws Exception {
                AppDatabase db = AppDatabase.getAppDatabase(context);

                return db.newsDao().getAll();
            }
        });
    }
    
    Observable<List<NewsEntity>> getDataObservable() {
        AppDatabase db = AppDatabase.getAppDatabase(context);

         return (Observable<List<NewsEntity>>) db.newsDao().getAll();

    }
}