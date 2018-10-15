package com.example.yossi.intentservicebasics;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntetntService extends IntentService {

    boolean isRun = true;

    public MyIntetntService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int n = intent.getExtras().getInt("counter");

        while (n > 0 && isRun)
        {
            try {
                Thread.sleep(1000);
                n--;
                Log.d("Intent service","n=" + n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopSelf();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        isRun=false;
        Toast.makeText(this,"Service destroyed",Toast.LENGTH_LONG).show();
    }
}
