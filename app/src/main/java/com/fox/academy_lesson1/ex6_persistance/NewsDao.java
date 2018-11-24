package com.fox.academy_lesson1.ex6_persistance;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<NewsEntity> getAll();

    @Insert(onConflict = REPLACE)
    void insertAll(NewsEntity... news);

    @Delete
    void delete(NewsEntity news);

    @Query("DELETE FROM news")
    void deleteAll();

    @Query("SELECT * FROM news WHERE title LIKE :title LIMIT 1")
    NewsEntity findByName(String title);

    @Query("SELECT * FROM news WHERE title IN (:titles)")
    List<NewsEntity> loadAllByTitles(String[] titles);
}