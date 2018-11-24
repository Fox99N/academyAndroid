package com.fox.academy_lesson1.ex6_persistance;

import android.content.Context;
import java.lang.annotation.Annotation;
import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {NewsEntity.class}, version = 1)
public abstract class AppDatabase implements Database {
    private static AppDatabase singleton;

    private static final String DATABASE_NAME = "FilmRoomDb.db";

    public abstract NewsDao newsDao();

    public abstract NewsAsyncDao filmAsyncDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (singleton == null) {
            synchronized (AppDatabase.class) {
                if (singleton == null) {
                    singleton = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            DATABASE_NAME)
                            .build();
                }
            }
        }
        return singleton;
    }
}