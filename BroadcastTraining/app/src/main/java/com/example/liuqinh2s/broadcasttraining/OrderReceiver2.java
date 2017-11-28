package com.example.liuqinh2s.broadcasttraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by liuqinh2s on 27/11/2017.
 */

public class OrderReceiver2 extends BroadcastReceiver {
    private static final String TAG = "OrderReceiver2";

    public OrderReceiver2(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "OrderReceiver2被调用");
        //取出上一优先级的Receiver传递来的数据
        String data = getResultExtras(true).getString("Data");
        Log.e(TAG, "从上一优先级的Receiver传递来的数据--"+data);
        String data1 = intent.getStringExtra("Msg");
        Log.e(TAG, "这是原始的广播："+data1);

        //向下一优先级的Receiver传递数据
        Bundle bundle = new Bundle();
        bundle.putString("Data", "这是来自OrderReceiver2的数据");
        setResultExtras(bundle);
    }
}
