package com.yyk.brocasereceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zhan on 2018/1/24.
 */

public class MyBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("test", "MyBroadCast=====>onReceive");
    }
}
