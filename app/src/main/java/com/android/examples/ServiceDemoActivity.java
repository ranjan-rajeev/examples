package com.android.examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ServiceDemoActivity extends AppCompatActivity {

    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);
    }

    public void startMyIntentService(View view) {
        i++;
        startService(new Intent(this, MyIntentService.class).putExtra("NAME", "" + i));
    }

    public void startMyService(View view) {
        i++;
        startService(new Intent(this, MyService.class).putExtra("NAME", "" + i));
    }


}
