package com.example.gauravgoyal.memoryleaksexample

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.ref.WeakReference
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.setOnClickListener { startActivity(Intent(this, AnonymousClassLeakActivity::class.java)) }

        // memory leak on rotation
        val obj = StaticClassWithActivityReference.getInstance(this)

    }
}
