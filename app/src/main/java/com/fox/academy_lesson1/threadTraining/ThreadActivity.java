package com.fox.academy_lesson1.threadTraining;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.fox.academy_lesson1.R;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

    }

    @Override
    public void onStart() {
        super.onStart();
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(new LeftLeg());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(new RightLeg());
    }

    class LeftLeg implements Runnable {
        private boolean isRunning = true;

        @Override
        public synchronized void run() {
                //  Log.i("info", "Current thread is: " + Thread.currentThread());
                for (int i = 0; i < 10; i++) {
                    System.out.println("Left step");
                } isRunning = false;
        }
    }

    class RightLeg implements Runnable {
        private boolean isRunning = true;

        @Override
        public synchronized void run() {
            try {
                wait(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Log.i("info", "Current thread is: " + Thread.currentThread());
                for (int i = 0; i <10 ; i++) {
                    System.out.println("Right step");
                } isRunning =false;
        }
    }
}

