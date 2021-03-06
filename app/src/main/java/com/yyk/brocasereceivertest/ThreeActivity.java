package com.yyk.brocasereceivertest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by zhan on 2018/1/24.
 */

public class ThreeActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        registBrocase(true);
        findViewById(R.id.tvThreeActivity).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvThreeActivity) {
            Intent intent = new Intent("TestAction");
            sendOrderedBroadcast(intent, null);

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
            filter.setPriority(12);
            registerReceiver(testBroad, filter);
        } else {
            unregisterReceiver(testBroad);
        }
    }

    BroadcastReceiver testBroad = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("test", "ThreeActivity=====>onReceive");
        }
    };

}
