package com.android.examples;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Rajeev Ranjan on 26-Jun-18.
 */

public class MyService extends Service {

    String name;
    Intent intent;

    @Override
    public void onCreate() {
        Log.d("MyService", "onCreate");
        super.onCreate();
    }


    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        this.intent = intent;
        this.name = intent.getStringExtra("NAME");
        asyncTask.execute();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyService", "onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("MyService", "onDestroy");
        Toast.makeText(this, "Destroying : " + name, Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {

        @Override
        protected void onPreExecute() {
            Log.d("MyService", "onStartCommand  onPreExecute - " + intent.getStringExtra("NAME"));
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Log.d("MyService", "onStartCommand  doInBackground - " + intent.getStringExtra("NAME"));
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("MyService", "onStartCommand onPostExecute - " + intent.getStringExtra("NAME"));
            stopSelf();
            super.onPostExecute(aVoid);
        }
    };
}
