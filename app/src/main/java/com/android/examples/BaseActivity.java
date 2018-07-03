package com.android.examples;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Rajeev Ranjan on 27-Jun-18.
 */

public class BaseActivity extends AppCompatActivity {
    ActivityManager.AppTask appTask;

    public String TAG = "BaseActivity";

    public void runnibgTask() {
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfoList = activityManager.getRunningTasks(10);
        Iterator<ActivityManager.RunningTaskInfo> itr = runningTaskInfoList.iterator();
        StringBuilder builder = new StringBuilder();
        builder.append("Start---  ");
        while (itr.hasNext()) {

            ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) itr.next();
            int id = runningTaskInfo.id;
            CharSequence desc = runningTaskInfo.description;
            int numOfActivities = runningTaskInfo.numActivities;
            String topActivity = runningTaskInfo.topActivity.getShortClassName();
            String baseActivity = runningTaskInfo.baseActivity.getShortClassName();
            if (!topActivity.contains("SearchLauncher")) {
                builder.append("ID - " + id + "  desc - " + desc + "  numOfActivities - "
                        + numOfActivities + "  topActivity - " + topActivity + "  baseActivity -" + baseActivity);
            }

        }
        Log.d(TAG, builder.toString());
    }

}
