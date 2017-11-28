package com.example.liuqinh2s.broadcasttraining;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liuqinh2s on 28/11/2017.
 */

public class BroadcastService extends Service {

    private static final String TAG = "BroadcastService";

    private BroadcastReceiver receiver;

    public BroadcastService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MainActivity.ACTION);
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e(TAG,"BroadcastService 接收到了广播");
            }
        };
        registerReceiver(receiver, intentFilter);
        Log.e(TAG, "BroadcastService注册了接收器");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.e(TAG, "BroadcastService取消注册接收器");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
