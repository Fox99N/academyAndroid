package com.fox.academy_lesson1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "EXTRA_MESS";
    private TextView myTextmsg;
    private Button sendMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myTextmsg = (TextView) findViewById(R.id.display_my_msg);
        sendMsg = (Button) findViewById(R.id.send_mail_btn);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            myTextmsg.setText(bundle.getString(EXTRA_MESSAGE));
        }


        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String msg = (String) myTextmsg.getText();
        String subject = getString(R.string.text_email_header);
        String email = getString(R.string.my_mail_address);
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto: " + email));
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
