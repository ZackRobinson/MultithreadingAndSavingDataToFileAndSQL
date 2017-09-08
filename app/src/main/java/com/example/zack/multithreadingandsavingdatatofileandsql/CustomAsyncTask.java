package com.example.zack.multithreadingandsavingdatatofileandsql;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Zack on 9/7/2017.
 */

public class CustomAsyncTask extends AsyncTask<String, Integer, String> {


    private static final String TAG = "CustomAsyncTaskTag";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: " + Thread.currentThread());
    }
    @Override
    protected String doInBackground(String... strings) {
        // when making a rest call, pass the url to async task
        Log.d(TAG, "doInBackground: " + Thread.currentThread());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: " + values[0] + " " + Thread.currentThread());
    }

    @Override
    protected void onPostExecute(String t) {
        super.onPostExecute(t);
        Log.d(TAG, "onPostExecute: " + Thread.currentThread());
    }
}
