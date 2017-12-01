package com.example.gauravgoyal.memoryleaksexample;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by gauravgoyal on 01/12/17.
 */

public class AnonymousClassLeakActivity extends AppCompatActivity {

    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                    Log.d(TAG, "Thread finished");
                } catch (InterruptedException e) {}
            }
        }).start();

    }
}
