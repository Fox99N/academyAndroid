package com.fox.academy_lesson1.new_list_ex;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.fox.academy_lesson1.R;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class NewsListActivity extends AppCompatActivity implements NewsListAdapter.ItemClickListener {
    private Context context;
    private RecyclerView recyclerView;
    private NewsListAdapter adapterNewList;
    private List<NewsItem> news;
    private Handler h;
    private ProgressBar progressBar;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_news_list);
        recyclerView = findViewById(R.id.recycler_news_list);
        progressBar = (ProgressBar)findViewById(R.id.news_list_progressbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(context, R.drawable.horizontal_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        recyclerView.addItemDecoration(horizontalDecoration);
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    @Override
    public void onItemClick(View view, int position) {
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private class MyAsyncTask extends AsyncTask<List<NewsItem>, Void, List<NewsItem>> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected List<NewsItem> doInBackground(List<NewsItem>... lists) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                news = DataUtils.generateNews(context);
            return news;
        }

        @Override
        protected void onPostExecute(List<NewsItem> newsItems) {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            adapterNewList = new NewsListAdapter(newsItems, getApplicationContext());
            recyclerView.setAdapter(adapterNewList);
            Toast.makeText(context, "Данные обновлены", Toast.LENGTH_LONG).show();
            super.onPostExecute(newsItems);
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

