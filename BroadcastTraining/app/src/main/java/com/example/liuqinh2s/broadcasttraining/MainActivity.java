package com.example.liuqinh2s.broadcasttraining;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String NORMAL_ACTION = "com.example.normal.receiver";
    public final static String ORDER_ACTION = "com.example.order.receiver";
    public final static String ACTION = "com.example.receiver";
    private String LOCAL_ACTION = "com.example.local.receiver";
    private final String PERMISSION_PRIVATE = "com.example.permission.receiver";

    private Button button1;
    private Button button2;
    private Button button_startService;
    private Button button_send;
    private Button button_stopService;
    private Button button_localreceiver;
    private Button button_permission;

    private LocalBroadcastManager localBroadcastManager;
    private LocalReceiver localReceiver;
    private PermissionReceiver permissionReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =  findViewById(R.id.button1);
        button2 =  findViewById(R.id.button2);
        button_startService = findViewById(R.id.button_startService);
        button_send = findViewById(R.id.button_send);
        button_stopService = findViewById(R.id.button_stopService);
        button_localreceiver = findViewById(R.id.button_localreceiver);
        button_permission = findViewById(R.id.button_permission);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNormalBroadcast(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOrderBroadcast(view);
            }
        });

        button_startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService();
            }
        });
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBroadcast();
            }
        });
        button_stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService();
            }
        });
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localReceiver = new LocalReceiver();
        IntentFilter intentFilter = new IntentFilter(LOCAL_ACTION);
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
        button_localreceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLocalBroadcast();
            }
        });
        permissionReceiver = new PermissionReceiver();
        IntentFilter intentFilter1 = new IntentFilter("HELLO");
        registerReceiver(permissionReceiver,intentFilter1,PERMISSION_PRIVATE,null);
        button_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPermissionBroadcast();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
        unregisterReceiver(permissionReceiver);
    }

    public void sendNormalBroadcast(View view) {
        Intent intent = new Intent(NORMAL_ACTION);
        intent.putExtra("Msg", "Hi");
        sendBroadcast(intent);
    }

    public void sendOrderBroadcast(View view){
        Intent intent = new Intent(ORDER_ACTION);
        intent.putExtra("Msg", "Hi");
        sendOrderedBroadcast(intent,null);
    }

    public void startService() {
        Intent intent = new Intent(this, BroadcastService.class);
        startService(intent);
    }

    public void sendBroadcast(){
        Intent intent = new Intent(ACTION);
        sendBroadcast(intent);
    }

    public void stopService(){
        Intent intent = new Intent(this, BroadcastService.class);
        stopService(intent);
    }

    public void sendLocalBroadcast(){
        Intent intent = new Intent(LOCAL_ACTION);
        localBroadcastManager.sendBroadcast(intent);
    }

    public void sendPermissionBroadcast(){
        Intent intent = new Intent("HELLO");
        sendBroadcast(intent, PERMISSION_PRIVATE);
    }
}
