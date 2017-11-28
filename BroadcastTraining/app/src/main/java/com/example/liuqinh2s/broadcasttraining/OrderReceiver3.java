package com.example.liuqinh2s.broadcasttraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by liuqinh2s on 27/11/2017.
 */

public class OrderReceiver3 extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver3";

    public OrderReceiver3(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "OrderReceiver3被调用");
        String data = getResultExtras(true).getString("Data");
        Log.e(TAG, "从上一优先级的Receiver传递来的数据--"+data);

    }
}
