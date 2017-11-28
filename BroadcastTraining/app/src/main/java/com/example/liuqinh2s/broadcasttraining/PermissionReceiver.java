package com.example.liuqinh2s.broadcasttraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by liuqinh2s on 28/11/2017.
 */

public class PermissionReceiver extends BroadcastReceiver {
    private static final String TAG = "PermissionReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "接收到了私有权限广播");
    }
}
