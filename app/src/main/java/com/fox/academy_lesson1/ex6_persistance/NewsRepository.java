package com.fox.academy_lesson1.ex6_persistance;

import android.content.Context;

import com.fox.academy_lesson1.networking_news.dto.ResultDTO;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.Callable;


public class NewsRepository {
    private final Context context;
    private NewsDao newsDao;
    private LiveData<List<NewsEntity>> newsEntity;

    public NewsRepository(Context context) {
        this.context = context;
    }

    public Completable saveData(final List<ResultDTO> newsList) {
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

        return Single.fromCallable(() -> {
            AppDatabase db = AppDatabase.getAppDatabase(context);

            return db.newsDao().getAll();
        });
    }

    public List<NewsEntity> getDataObservable() {
        AppDatabase db = AppDatabase.getAppDatabase(context);

         return (List<NewsEntity>) db.newsDao().getAll();

    }
    public void insert (NewsEntity newsEntity) {
        new NewsAsyncDao(newsDao).execute(newsEntity);
    }

    public void deleteAll(){
        AppDatabase db = AppDatabase.getAppDatabase(context);
        db.newsDao().deleteAll();
    }
}