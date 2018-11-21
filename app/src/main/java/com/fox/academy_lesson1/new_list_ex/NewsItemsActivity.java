package com.fox.academy_lesson1.new_list_ex;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fox.academy_lesson1.R;
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

    protected static void start(@NonNull Context context, @NonNull NewsItem newsItem) {
        context.startActivity(new Intent(context, NewsItemsActivity.class).putExtra(EXTRA_NEWS_ITEM, newsItem));
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

}

