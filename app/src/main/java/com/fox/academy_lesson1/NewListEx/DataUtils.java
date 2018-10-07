package com.fox.academy_lesson1.NewListEx;
import android.content.res.Resources;
import android.icu.util.ULocale;

import com.fox.academy_lesson1.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by fox on 07.10.18.
 */

public class DataUtils {
    public static List<NewsItem> generateNews() {

        NewsItem.Category pandasWorld = new NewsItem.Category(1, Resources.getSystem().getString(R.string.category_panda));
        NewsItem.Category robots = new NewsItem.Category(2, Resources.getSystem().getString(R.string.category_robots));
        NewsItem.Category augmentedReallity = new NewsItem.Category(3, Resources.getSystem().getString(R.string.category_augmented_reality));
        NewsItem.Category positive = new NewsItem.Category(4, Resources.getSystem().getString(R.string.category_fun));

        List<NewsItem> news = new ArrayList<>();

        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                "https://www.gettyimages.com/detail/photo/panda-with-tongue-out-royalty-free-image/184987985",
                pandasWorld,
                createDate(2018,10, 5, 10,26),
                Resources.getSystem().getString(R.string.preview_text_panda),
                Resources.getSystem().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                "https://www.gettyimages.com/detail/photo/panda-with-tongue-out-royalty-free-image/184987985",
                pandasWorld,
                createDate(2018,10, 5, 10,26),
                Resources.getSystem().getString(R.string.preview_text_panda),
                Resources.getSystem().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                "https://www.gettyimages.com/detail/photo/panda-with-tongue-out-royalty-free-image/184987985",
                pandasWorld,
                createDate(2018,10, 5, 10,26),
                Resources.getSystem().getString(R.string.preview_text_panda),
                Resources.getSystem().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                "https://www.gettyimages.com/detail/photo/panda-with-tongue-out-royalty-free-image/184987985",
                pandasWorld,
                createDate(2018,10, 5, 10,26),
                Resources.getSystem().getString(R.string.preview_text_panda),
                Resources.getSystem().getString(R.string.full_text_panda)
        ));
        news.add(new NewsItem(
                "Decoding Pandas’ Come-Hither Calls",
                "https://www.gettyimages.com/detail/photo/panda-with-tongue-out-royalty-free-image/184987985",
                pandasWorld,
                createDate(2018,10, 5, 10,26),
                Resources.getSystem().getString(R.string.preview_text_panda),
                Resources.getSystem().getString(R.string.full_text_panda)
        ));

        return news;
    }


    private static Date createDate(int year, int month, int date, int hrs, int min) {
        return new GregorianCalendar(year, month - 1, date, hrs, min).getTime();
    }
}
