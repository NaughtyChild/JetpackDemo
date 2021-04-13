package com.naughtychild.jetpack.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.util.Log;

import com.naughtychild.jetpack.R;

import java.util.concurrent.TimeUnit;

public class WorkerManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woker_manager);
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(LogWorker.class)
                .addTag("log")
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build();
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
        observeWorker(this, oneTimeWorkRequest);
    }

    public void observeWorker(WorkerManagerActivity context, WorkRequest workRequest) {
        WorkManager.getInstance(context).getWorkInfoByIdLiveData(workRequest.getId()).observe(context, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                //展示workInfo的信息
                Log.d("WorkManagerCombine", "onChanged: ");
            }
        });
    }
}