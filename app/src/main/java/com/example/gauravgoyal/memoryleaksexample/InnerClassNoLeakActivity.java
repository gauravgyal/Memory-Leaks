package com.example.gauravgoyal.memoryleaksexample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by gauravgoyal on 01/12/17.
 */

public class InnerClassNoLeakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyAsyncTask((TextView) findViewById(R.id.text_view)).execute();
        Intent i = new Intent(this, MainActivity.class);

    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, String> {

        private final WeakReference<TextView> textViewWeakReference;

        public MyAsyncTask(TextView textView) {
            this.textViewWeakReference = new WeakReference<>(textView);
        }

        @Override
        protected void onCancelled() {
        }

        @Override
        protected String doInBackground(Void... params) {
            try {Thread.sleep(10000);} catch (InterruptedException e) {}
            return "some text";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = textViewWeakReference.get();
            if (textView != null)
                textView.setText(result);
        }
    }
}
