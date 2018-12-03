package com.fox.academy_lesson1.networking_news.news_ui;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fox.academy_lesson1.R;
import com.fox.academy_lesson1.ex6_persistance.AppDatabase;
import com.fox.academy_lesson1.ex6_persistance.NewsViewModal;
import com.fox.academy_lesson1.networking_news.RestApi;
import com.fox.academy_lesson1.networking_news.dto.MultimediaDTO;
import com.fox.academy_lesson1.networking_news.dto.NewsDTO;
import com.fox.academy_lesson1.networking_news.dto.ResultDTO;
import android.os.AsyncTask;

import java.util.List;

import androidx.room.Room;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class NewsFromServerActivity extends AppCompatActivity {
    private Context context;
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
    private TextView newsTopic;
    private static AppDatabase appDatabase;
    private NewsViewModal newsViewModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_from_server);
        appDatabase = Room.databaseBuilder(this, AppDatabase.class, "database")
                      .build();
        newsFSpb = findViewById(R.id.news_frm_server_progress_bar);
        newsLoadError = findViewById(R.id.error_load_data_text);
        serverError = findViewById(R.id.error_server_text);
        newsFromServerRecycler = findViewById(R.id.news_from_server_recycler);
        newsFromServerRecycler.setLayoutManager(new LinearLayoutManager(this));
        newsTopic = findViewById(R.id.choose_type_nesw_text);
//        newsViewModal = ViewModelProvider.of(this).get(NewsViewModal.class);  TODO ошибка в методе
        newsTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
                myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();

    }

    private void showAlertDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
       // View promts = layoutInflater.inflate(R.layout.allert_dialog_editmeasurements, null);//
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.choose_topic_text_title);
        String[] topicks =  {"technology", "opinion", "politics", "business", "science", "health"};
        final String topic = " ";
        int checkedItem = 0;
        alertDialog.setSingleChoiceItems(topicks, checkedItem, (DialogInterface dialog, int which) -> {
                });
        alertDialog.setPositiveButton("OK", (dialog, which) -> {
            String selectedItem = topicks[((AlertDialog) dialog).getListView().getCheckedItemPosition()];
            Log.d("string topic", selectedItem);
            loadNewsWithChosenTopic(selectedItem);
            newsTopic.setText(selectedItem);
            //TODO не забыть в апи поставить выбранную тему и  переделать откурыти в веб вью
        });
         alertDialog.setNegativeButton(R.string.alert_cancel_btn, null);
         AlertDialog dialog = alertDialog.create();
         dialog.show();
    }

    private void loadNewsWithChosenTopic(String topic) {
        showState(State.Loading);
        searchRequest = RestApi.getInstance()
                .newsDownload()
                .searchFromChosenTopic(topic);
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

    private class MyAsyncTask extends AsyncTask<List<NewsDTO>, Void, List<NewsDTO>[]> {

        @Override
        protected List<NewsDTO>[] doInBackground(List<NewsDTO>... lists) {//TODO доделать метод загрузки данных не забыть убрать null
            loadNews();
            return lists;
        }

        @Override
        protected void onPreExecute() {
            newsFSpb.setVisibility(ProgressBar.VISIBLE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
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
    public static AppDatabase getDatabase(){
        return appDatabase;
    }

    private void loadNews() {
        showState(State.Loading);
        searchRequest = RestApi.getInstance()
                .newsDownload()
                .searchDefault();
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
        newsFromServerAdapter.notifyDataSetChanged();
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



