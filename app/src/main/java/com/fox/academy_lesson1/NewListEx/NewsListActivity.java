package com.fox.academy_lesson1.NewListEx;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fox.academy_lesson1.R;

public class NewsListActivity extends AppCompatActivity implements AdapterNewList.ItemClickListener{
    private RecyclerView recyclerView;
    private  AdapterNewList adapterNewList;
    private NewsItem newsItem;
    private  Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

         adapterNewList = new AdapterNewList(DataUtils.generateNews(this), this);
         recyclerView = findViewById(R.id.recycler_news_list);
         recyclerView.setAdapter(adapterNewList);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onItemClick(View view, int position) {

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

