package com.fox.academy_lesson1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCardActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView photo;
    private ImageView skill1;
    private ImageView skill2;
    private ImageView skill3;
    private TextView textskill1;
    private TextView textskill2;
    private TextView textskill3;
    private TextView bigInfo;
    private EditText typedText;
    private Button sendEmailBrowserBtn;
    private ImageButton openTelegramm;
    private ImageButton openGitHub;
    private ImageButton openInstagram;
    public String msg;
    public String email;
    public String subject;
    public String parseLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_card_activity);
        photo = findViewById(R.id.photo);
        skill1 = findViewById(R.id.img_skill1);
        skill2 = findViewById(R.id.img_skill2);
        skill3 = findViewById(R.id.img_skill3);
        textskill1 = findViewById(R.id.text_skill1);
        textskill2 = findViewById(R.id.text_skill2);
        textskill3 = findViewById(R.id.text_skill3);
        bigInfo = findViewById(R.id.text_description);
        typedText = findViewById(R.id.input_message);
        sendEmailBrowserBtn = findViewById(R.id.btn_send_email);
        openGitHub = findViewById(R.id.open_github_img);
        openTelegramm = findViewById(R.id.open_telega_img);
        openInstagram = findViewById(R.id.open_instagram_img);
        subject = getString(R.string.text_email_header);
        sendEmailBrowserBtn.setOnClickListener(this);
        openTelegramm.setOnClickListener(this);
        openGitHub.setOnClickListener(this);
        openInstagram.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        email = getString(R.string.my_mail_address);
        msg = typedText.toString();
        switch (v.getId()) {

            case R.id.send_mail_btn:
                parseLink = "https://mail.google.com/mail/u/0/?tab=wm#inbox" + email;
                sendMessage(parseLink);
                break;

            case R.id.open_github_img:
                parseLink = "https://github.com/";
                openMyContact(parseLink);
                break;

            case R.id.open_telega_img:
                parseLink = "https://telegram.com";
                openMyContact(parseLink);
                break;

            case R.id.open_instagram_img:
                parseLink = "https://www.instagram.com/?hl=ru";
                openMyContact(parseLink);
                break;
        }
    }

    public void openMyContact(String parse) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(parse));
        startActivity(intent);
    }

    private void sendMessage(String parse) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(parse));//еще доделываю чтоб адресат ставился и текст сохранялся
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(sendIntent, "Send letter"));
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


