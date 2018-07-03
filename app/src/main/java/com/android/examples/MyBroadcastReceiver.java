package com.android.examples;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Rajeev Ranjan on 26-Jun-18.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "" + intent.getStringExtra("MSG"), Toast.LENGTH_SHORT).show();
        if (context instanceof MainActivity) {
            ((MainActivity) context).updateUI(intent.getStringExtra("MSG"));
        }
    }
}
