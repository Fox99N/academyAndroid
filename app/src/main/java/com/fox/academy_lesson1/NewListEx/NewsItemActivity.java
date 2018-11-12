package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.fox.academy_lesson1.R;

public class NewsItemActivity extends AppCompatActivity {
    private static final String EXTRA_NEWS_ITEM = "ITEM_NEWS";
    private ImageView imageNews;
    private TextView authorNews;
    private TextView previewNews;
    private TextView fullText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_news_activity);
        imageNews = (ImageView) findViewById(R.id.image_news_big_image);
        authorNews = (TextView) findViewById(R.id.news_author_txt_full);
        previewNews = (TextView) findViewById(R.id.news_preview_txt_full);
        fullText = (TextView) findViewById(R.id.news_descriptions_txt_full);
        Intent intent = getIntent();
        NewsItem newsItem =(NewsItem) intent.getSerializableExtra(EXTRA_NEWS_ITEM);

        if (intent != null) {
            imageNews.setBackgroundResource(newsItem.getImageUrl());
            authorNews.setText(newsItem.getAuthor());
            previewNews.setText(newsItem.getPreviewText());
            fullText.setText(newsItem.getFullText());
        }
    }
    public static void start(@NonNull Context context, @NonNull NewsItem newsItem) {
        context.startActivity(new Intent(context, NewsItemActivity.class).putExtra(EXTRA_NEWS_ITEM, newsItem));
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}


