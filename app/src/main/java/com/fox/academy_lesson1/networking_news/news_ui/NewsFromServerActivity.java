package com.fox.academy_lesson1.networking_news.news_ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.networking_news.DefaultResponse;
import com.fox.academy_lesson1.networking_news.dto.NewsDTO;
import com.fox.academy_lesson1.new_list_ex.DataUtils;
import com.fox.academy_lesson1.new_list_ex.NewsItem;

import android.os.AsyncTask;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;

public class NewsFromServerActivity extends AppCompatActivity {
    private RecyclerView newsFromServerRecycler;
    private NewFromServerAdapter newFromServerAdapter;
    private ProgressBar newsFSpb;
    private TextView newsLoadError;
    private TextView serverError;
    private MyAsyncTask myAsyncTask;

    @NonNull
    private Call<DefaultResponse<List<NewsDTO>>> searchRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_from_server);
        newsFSpb = findViewById(R.id.news_frm_server_progress_bar);
        newsLoadError = findViewById(R.id.error_load_data_text);
        serverError= findViewById(R.id.error_server_text);
        newsFromServerRecycler = findViewById(R.id.news_from_server_recycler);
        newsFromServerRecycler.setLayoutManager(new LinearLayoutManager(this));
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
        }

    private class  MyAsyncTask extends AsyncTask<List<NewsDTO>, Void, List<NewsDTO>> {

        @Override
        protected List<NewsDTO> doInBackground(List<NewsDTO>[] lists) {//TODO доделать метод загрузки данных не забыть убрать null
            return null;
             }

        @Override
        protected void onPreExecute() {
                newsFSpb.setVisibility(ProgressBar.VISIBLE);
              }
        }

    }



