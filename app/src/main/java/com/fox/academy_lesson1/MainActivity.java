package com.fox.academy_lesson1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView hint;
    private EditText myMessage;
    private Button previewBtn;
    public static final String EXTRA_MESSAGE = "EXTRA_MESS";
    public static Button myCardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hint = (TextView)findViewById(R.id.text_hint);
        myMessage = (EditText)findViewById(R.id.my_msg);
        previewBtn = (Button)findViewById(R.id.open_sec_activity_btn);
        myCardBtn = (Button)findViewById(R.id.open_my_profile);


        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivivity();

            }
        });

        myCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMyCard();
            }
        });


    }

    private void openMyCard() {
        Intent intent = new Intent(this, MyCardActivity.class );
        startActivity(intent);
    }


    public void openNewActivivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        String message = myMessage.getText().toString();
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
