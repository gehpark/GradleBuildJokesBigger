package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.gracepark.myapplication.backend.myApi.MyApi;
import com.example.jokeandroidlibrary.MainAndroidActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import static com.example.jokeandroidlibrary.MainAndroidActivity.EXTRA_JOKE;

/**
 * AsyncTask to fetch jokes from JokeTeller of jokeJavaLibrary.
 */

public class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://joketellerudacity.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, MainAndroidActivity.class);
        intent.putExtra(EXTRA_JOKE, result);
        context.startActivity(intent);
    }
}

