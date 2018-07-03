package com.android.examples;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

public class Activity_A extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate - " + this.getClass().getName());
        setContentView(R.layout.activity_a);
        runnibgTask();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart - " + this.getClass().getName());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState - " + this.getClass().getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume - " + this.getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause - " + this.getClass().getName());
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState - " + this.getClass().getName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop - " + this.getClass().getName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart - " + this.getClass().getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy - " + this.getClass().getName());
    }




    public void startA(View view) {
        startActivity(new Intent(this, Activity_A.class));
    }

    public void startB(View view) {
        startActivity(new Intent(this, Activity_B.class));
    }

    public void startC(View view) {
        startActivity(new Intent(this, Activity_C.class));
    }

    public void startD(View view) {
        startActivity(new Intent(this, Activity_D.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "" + intent.getStringExtra("ID"));
        runnibgTask();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
