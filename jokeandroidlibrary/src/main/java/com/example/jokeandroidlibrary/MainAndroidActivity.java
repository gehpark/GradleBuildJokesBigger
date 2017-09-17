package com.example.jokeandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Activity to display joke.
 */

public class MainAndroidActivity extends AppCompatActivity {

    public final static String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_main);

        Intent intent = getIntent();
        ((TextView) findViewById(R.id.joke_text)).setText(intent.getStringExtra(EXTRA_JOKE));
    }
}
