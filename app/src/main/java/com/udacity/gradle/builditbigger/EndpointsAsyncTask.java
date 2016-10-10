package com.udacity.gradle.builditbigger;

/**
 * Created by Nikola on 10/9/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.example.mylibrary.MainAndroidActivity;
import com.example.nikola.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    public final static String EXTRA_MESSAGE = "MESSAGE";


    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://bulditbigger-145218.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];
//        String name = params[0].second;

        try {
            return myApiService.sayHi(String.valueOf(params)).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, MainAndroidActivity.class);
        intent.putExtra(EXTRA_MESSAGE, result);
        context.startActivity(intent);
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }


}