package com.fox.academy_lesson1.networking_news.news_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.networking_news.dto.ResultDTO;

public class NewsItemFromServerActivity extends AppCompatActivity {
    private static final String EXTRA_NEWS_ITEM_SERVER = "ITEM_FROM_SERVER";
    private ImageView newsItemImage;
    private TextView newsItemAuthor;
    private TextView newsItemTitle;
    private TextView newsItemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item_from_server);
        newsItemImage = findViewById(R.id.image_news_item_server_big_image);
        newsItemAuthor = findViewById(R.id.item_news_server_author_txt_full);
        newsItemTitle = findViewById(R.id.item_news_title);
        newsItemDescription  = findViewById(R.id.item_news_descriptions_server_txt_full);
        Bundle bundle = getIntent().getExtras();
        ResultDTO resultDTO = (ResultDTO) bundle.getSerializable(EXTRA_NEWS_ITEM_SERVER);//FIXME  cast exception
 /*       FATAL EXCEPTION: main
        Process: com.fox.nytimes, PID: 17412
        java.lang.RuntimeException: Unable to start activity
        ComponentInfo{com.fox.nytimes/com.fox.academy_lesson1.networking_news.news_ui.NewsItemFromServerActivity}:
        java.lang.ClassCastException: java.lang.Integer cannot be cast to com.fox.academy_lesson1.networking_news.dto.ResultDTO*/
        if(bundle != null){
            Glide.with(this).load(resultDTO.getMultimedia().get(0).getNewsImageUrl()).into(newsItemImage);
            newsItemAuthor.setText(resultDTO.getAuthor());
            newsItemTitle.setText(resultDTO.getTitle());
            newsItemDescription.setText(resultDTO.getAbstractDescription());
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

