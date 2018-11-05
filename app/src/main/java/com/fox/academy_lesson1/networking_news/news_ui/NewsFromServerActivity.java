package com.fox.academy_lesson1.networking_news.news_ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.networking_news.RestApi;
import com.fox.academy_lesson1.networking_news.dto.MultimediaDTO;
import com.fox.academy_lesson1.networking_news.dto.NewsDTO;
import com.fox.academy_lesson1.networking_news.dto.ResultDTO;
import android.os.AsyncTask;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFromServerActivity extends AppCompatActivity {
    private RecyclerView newsFromServerRecycler;
    private NewsFromServerAdapter newsFromServerAdapter;
    private ProgressBar newsFSpb;
    private TextView newsLoadError;
    private TextView serverError;
    private MyAsyncTask myAsyncTask;
    private MultimediaDTO multimediaDTO;
    private ResultDTO resultDTO;
    @NonNull
    private Call<NewsDTO> searchRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_from_server);
        newsFSpb = findViewById(R.id.news_frm_server_progress_bar);
        newsLoadError = findViewById(R.id.error_load_data_text);
        serverError = findViewById(R.id.error_server_text);
        newsFromServerRecycler = findViewById(R.id.news_from_server_recycler);
        newsFromServerRecycler.setLayoutManager(new LinearLayoutManager(this));
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    private class MyAsyncTask extends AsyncTask<List<NewsDTO>, Void, List<NewsDTO>> {

        @Override
        protected List<NewsDTO> doInBackground(List<NewsDTO>[] lists) {//TODO доделать метод загрузки данных не забыть убрать null
            return null;
        }

        @Override
        protected void onPreExecute() {
            newsFSpb.setVisibility(ProgressBar.VISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadNews();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindUx();
    }

    private void loadNews() {
        showState(State.Loading);
        searchRequest = RestApi.getInstance()
                .newsDounload()
                .search();
        Log.e("searchRequest IS ", String.valueOf(searchRequest));
        searchRequest.enqueue(new Callback<NewsDTO>() {

            @Override
            public void onResponse(Call<NewsDTO> call, Response<NewsDTO> response) {
                Log.e("call" + call, String.valueOf(response));
                checkResponseAndShowState(response);
            }

            @Override
            public void onFailure(Call<NewsDTO> call, Throwable t) {

            }
        });
    }

    private void checkResponseAndShowState(@NonNull Response<NewsDTO> response) {
        if (!response.isSuccessful()) {
            showState(State.ServerError);
        }
        final NewsDTO body = response.body();
        Log.e("", body.toString());
        final List<ResultDTO> resultDTO = body.getResults();
        if (body == null || resultDTO == null || resultDTO.isEmpty()) {
            showState(State.HasNoData);
        }
        newsFromServerAdapter = new NewsFromServerAdapter(resultDTO, getApplicationContext());
        newsFromServerRecycler.setAdapter(newsFromServerAdapter);
        showState(State.HasData);

    }

    private void showState(State state) {
        switch (state) {
            case HasData:
                newsFSpb.setVisibility(ProgressBar.GONE);
                newsFromServerRecycler.setVisibility(RecyclerView.VISIBLE);
                serverError.setVisibility(TextView.GONE);
                newsLoadError.setVisibility(TextView.GONE);
                break;
            case HasNoData:
                newsFromServerRecycler.setVisibility(View.GONE);
                serverError.setVisibility(TextView.GONE);
                newsLoadError.setVisibility(TextView.VISIBLE);
                break;
            case ServerError:
                newsFromServerRecycler.setVisibility(RecyclerView.GONE);
                serverError.setVisibility(TextView.VISIBLE);
                newsLoadError.setVisibility(TextView.GONE);
                break;
            case Loading:
                newsFSpb.setVisibility(ProgressBar.VISIBLE);
                newsFromServerRecycler.setVisibility(RecyclerView.GONE);
                serverError.setVisibility(TextView.GONE);
                newsLoadError.setVisibility(TextView.GONE);
                break;
        }
    }

    private void unbindUx() {
        if (searchRequest == null) {
            return;
        }
        if (searchRequest.isCanceled()) {
            searchRequest = null;
            return;
        }

        if (searchRequest.isExecuted()) {
            searchRequest.cancel();
            searchRequest = null;
        }
    }
}



