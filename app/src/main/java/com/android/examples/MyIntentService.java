package com.android.examples;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Rajeev Ranjan on 03-Jul-18.
 */

public class MyIntentService extends IntentService {
    String name;

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {
        try {
            this.name = intent.getStringExtra("NAME");
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Destroying : " + name, Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
