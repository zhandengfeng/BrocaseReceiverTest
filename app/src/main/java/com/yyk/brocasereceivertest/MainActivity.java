package com.yyk.brocasereceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registBrocase(true);
        findViewById(R.id.tvStartSecondActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvStartSecondActivity) {
            startActivity(new Intent(this, SecondActivity.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registBrocase(false);
    }

    private void registBrocase(boolean register) {
        if (register) {
            IntentFilter filter = new IntentFilter("TestAction");
            filter.setPriority(10);
            registerReceiver(testBroad, filter);
        } else {
            unregisterReceiver(testBroad);
        }
    }

    BroadcastReceiver testBroad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("test", "MainActivity=====>onReceive");
        }
    };
}
