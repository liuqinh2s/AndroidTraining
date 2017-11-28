package com.example.liuqinh2s.broadcasttraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by liuqinh2s on 27/11/2017.
 */

public class OrderReceiver1 extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver1";
    public OrderReceiver1(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "OrderReceiver1被调用");
        String msg = intent.getStringExtra("Msg");
        Log.e(TAG, "OrderReceiver1接收到的："+msg);
        abortBroadcast();
        Bundle bundle = new Bundle();
        bundle.putString("Data", "Hello");
        setResultExtras(bundle);
    }
}
