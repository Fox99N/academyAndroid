package com.fox.academy_lesson1.NewListEx;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.fox.academy_lesson1.R;

import java.io.Serializable;
import java.util.List;

public class NewActivity2 extends AppCompatActivity {
    private ImageView imageNews;
    private TextView authorNews;
    private TextView previewNews;
    private TextView fullText;



    private final String ITEM_MESSAGE = "ITEM_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_news_activity);
        imageNews = (ImageView) findViewById(R.id.image_news_big_image);
        authorNews = (TextView) findViewById(R.id.news_author_txt_full);
        previewNews = (TextView) findViewById(R.id.news_preview_txt_full);
        fullText = (TextView) findViewById(R.id.news_descriptions_txt_full);
        Bundle bundle = getIntent().getExtras();
        NewsItem newsItem =(NewsItem) bundle.getSerializable(ITEM_MESSAGE);

        if (bundle != null) {
            imageNews.setBackgroundResource(newsItem.getImageUrl());
            authorNews.setText(newsItem.getAuthor());
            previewNews.setText(newsItem.getPreviewText());
            fullText.setText(newsItem.getFullText());
        }
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

