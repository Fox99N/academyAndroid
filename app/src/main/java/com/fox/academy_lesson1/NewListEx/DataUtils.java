package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.content.res.Resources;
import android.icu.util.ULocale;
import android.support.v4.content.ContextCompat;

import com.fox.academy_lesson1.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Created by fox on 07.10.18.
 */

public class DataUtils {

    public static List<NewsItem> generateNews(Context context) {

        List<NewsItem> news = new ArrayList<>();

        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                ContextCompat.getDrawable(context, R.drawable.panda),
                context.getApplicationContext().getResources().getString(R.string.category_panda),
                createDate(2018, 10, 5, 10, 26),
                context.getApplicationContext().getResources().getString(R.string.preview_text_panda),
                context.getApplicationContext().getResources().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                ContextCompat.getDrawable(context, R.drawable.panda),
                context.getApplicationContext().getResources().getString(R.string.category_panda),
                createDate(2018, 10, 5, 10, 26),
                context.getApplicationContext().getResources().getString(R.string.preview_text_panda),
                context.getApplicationContext().getResources().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                ContextCompat.getDrawable(context, R.drawable.panda),
                context.getApplicationContext().getResources().getString(R.string.category_panda),
                createDate(2018, 10, 5, 10, 26),
                context.getApplicationContext().getResources().getString(R.string.preview_text_panda),
                context.getApplicationContext().getResources().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                ContextCompat.getDrawable(context, R.drawable.panda),
                context.getApplicationContext().getResources().getString(R.string.category_panda),
                createDate(2018, 10, 5, 10, 26),
                context.getApplicationContext().getResources().getString(R.string.preview_text_panda),
                context.getApplicationContext().getResources().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                ContextCompat.getDrawable(context, R.drawable.panda),
                context.getApplicationContext().getResources().getString(R.string.category_panda),
                createDate(2018, 10, 5, 10, 26),
                context.getApplicationContext().getResources().getString(R.string.preview_text_panda),
                context.getApplicationContext().getResources().getString(R.string.full_text_panda)
        ));
        return news;
    }


    private static Date createDate(int year, int month, int date, int hrs, int min) {
        return new GregorianCalendar(year, month - 1, date, hrs, min).getTime();
    }
}
