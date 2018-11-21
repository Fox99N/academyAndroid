package com.fox.academy_lesson1.networking_news.news_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.networking_news.dto.ResultDTO;

public class NewsItemFromServerActivity extends AppCompatActivity {
    private static final String EXTRA_NEWS_ITEM_SERVER = "ITEM_FROM_SERVER";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item_webview);
        webView = findViewById(R.id.webView);
        Bundle bundle = getIntent().getExtras();
        ResultDTO resultDTO = (ResultDTO) bundle.getSerializable(EXTRA_NEWS_ITEM_SERVER);
        Log.e("webview URL", resultDTO.getUrl());
        webView.loadUrl(resultDTO.getUrl());
        if(bundle != null){
            Log.e("webview URL", resultDTO.getUrl());
            webView.loadUrl(resultDTO.getUrl());
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

