package com.fox.academy_lesson1.new_list_ex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fox.academy_lesson1.R;

public class NewsListActivity extends AppCompatActivity implements NewsListAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private NewsListAdapter adapterNewList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        adapterNewList = new NewsListAdapter(this, newsItem -> NewsItemActivity.start(this, newsItem));
        recyclerView = findViewById(R.id.recycler_news_list);
        recyclerView.setAdapter(adapterNewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(context, R.drawable.horizontal_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        recyclerView.addItemDecoration(horizontalDecoration);
        adapterNewList.replaceItems(DataUtils.generateNews(context));
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

    @Override
    public void onItemClick(NewsItem newsItem) {

    }
}

