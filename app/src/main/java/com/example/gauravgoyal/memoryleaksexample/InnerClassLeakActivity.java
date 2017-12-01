package com.example.gauravgoyal.memoryleaksexample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by gauravgoyal on 01/12/17.
 */

public class InnerClassLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyAsyncTask((TextView) findViewById(R.id.text_view)).execute();

    }

    private class MyAsyncTask extends AsyncTask<Void, Void, String> {

        private final TextView textView;

        public MyAsyncTask(TextView textView) {
            this.textView = textView;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {Thread.sleep(10000);} catch (InterruptedException e) {}
            return "some text";
        }

        @Override
        protected void onPostExecute(String result) {
            if (textView != null)
                textView.setText(result);
        }
    }
}
