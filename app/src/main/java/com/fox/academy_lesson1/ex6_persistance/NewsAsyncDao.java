package com.fox.academy_lesson1.ex6_persistance;

import android.os.AsyncTask;

public class NewsAsyncDao extends AsyncTask<NewsEntity, Void, Void> {
    private NewsDao newsDao;

    public NewsAsyncDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    protected Void doInBackground(NewsEntity... newsEntities) {
        newsDao.insert(newsEntities[0]);
        return null;
    }
}
