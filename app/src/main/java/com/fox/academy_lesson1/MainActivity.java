package com.fox.academy_lesson1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.fox.academy_lesson1.new_list_ex.NewsListActivity;
import com.fox.academy_lesson1.thread_training.ThreadActivity;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_MESSAGE = "EXTRA_MESS";
    private Button myCardBtn;
    private Button newsBtn;
    private Button threadBtn;
    private TextView description;
    private EditText msgEditText;
    private Button previewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        description = (TextView) findViewById(R.id.description_hint_text);
        msgEditText = (EditText) findViewById(R.id.my_msg);
        previewBtn = (Button) findViewById(R.id.open_sec_activity_btn);
        myCardBtn = (Button) findViewById(R.id.open_my_profile_btn);
        newsBtn = (Button) findViewById(R.id.watch_news_btn);
        threadBtn = (Button) findViewById(R.id.thread_btn);
        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        myCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyCard();
            }
        });
        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewsActivity();
            }
        });
        threadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThreadActivity();
            }
        });
    }

    private void openMyCard() {
        Intent intent = new Intent(this, MyCardActivity.class);
        startActivity(intent);
    }

    private void openNewsActivity() {
        Intent intent = new Intent(this, NewsListActivity.class);
        startActivity(intent);
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = msgEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void openThreadActivity() {
        Intent intent = new Intent(this, ThreadActivity.class);
        String message = msgEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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
