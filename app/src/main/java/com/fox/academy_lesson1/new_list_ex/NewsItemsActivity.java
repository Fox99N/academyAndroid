package com.fox.academy_lesson1.new_list_ex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fox.academy_lesson1.R;

public class NewsItemsActivity extends AppCompatActivity {
    private final String EXTRA_NEWS_ITEM = "ITEM_NEWS";
    private ImageView imageNews;
    private TextView authorNews;
    private TextView previewNews;
    private TextView fullText;
    private ProgressBar progressNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_news_activity);
        imageNews = findViewById(R.id.image_news_big_image);
        authorNews = findViewById(R.id.news_author_txt_full);
        previewNews = findViewById(R.id.news_preview_txt_full);
        fullText = findViewById(R.id.news_descriptions_txt_full);
        progressNews = findViewById(R.id.news_list_progressbar);
                Bundle bundle = getIntent().getExtras();
        NewsItem newsItem =(NewsItem) bundle.getSerializable(EXTRA_NEWS_ITEM);

        if (bundle != null) {
            imageNews.setBackgroundResource(newsItem.getImageUrl());
            authorNews.setText(newsItem.getAuthor());
            previewNews.setText(newsItem.getPreviewText());
            fullText.setText(newsItem.getFullText());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
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

