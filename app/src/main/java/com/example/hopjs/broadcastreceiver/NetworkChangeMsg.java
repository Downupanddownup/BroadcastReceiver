package com.example.hopjs.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hopjs on 2017/1/17.
 */

public class NetworkChangeMsg extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,":NetworkChangeMsg="+intent.getStringExtra("msg"),
                Toast.LENGTH_SHORT).show();
        Log.i("BroadcastReceiver0",":NetworkChangeMsg="+intent.getStringExtra("msg"));
    }
}
