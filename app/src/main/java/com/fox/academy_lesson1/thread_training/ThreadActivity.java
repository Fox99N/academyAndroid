package com.fox.academy_lesson1.thread_training;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.fox.academy_lesson1.R;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadActivity extends AppCompatActivity {
    private static final Object object = new Object();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        Executor executor = Executors.newFixedThreadPool(2);

    }

    @Override
    public void onStart() {
        super.onStart();
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(new LeftLeg());
        executor.execute(new RightLeg());
    }

   class LeftLeg implements Runnable {

       @Override
        public void run() {
            synchronized (object) {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Left step");
                        object.notify();
                        object.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notifyAll();
            }
        }
    }

        class RightLeg implements Runnable {

            @Override
            public void run() {
                synchronized (object) {
                    try {
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Right step");
                            object.notify();
                            object.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.notifyAll();
                }
            }
        }


}



