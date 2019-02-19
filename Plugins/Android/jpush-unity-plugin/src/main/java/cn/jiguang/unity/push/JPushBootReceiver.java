package cn.jiguang.unity.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.lang.*;

import cn.jpush.android.api.JPushInterface;

public class JPushBootReceiver extends BroadcastReceiver {
    //重写onReceive方法
    @Override
    public void onReceive(Context context, Intent intent) {
        String gameObject = JPushBridge.loadGameObjectName(context);
        Log.d("JPush", "JPushBootReceiver onReceive "+intent.getAction()+". gameObject=\"" + gameObject + "\"");
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            if (gameObject != null && gameObject.length() > 0) {
                JPushInterface.init(context);
                JPushInterface.resumePush(context);
            }
        }
    }
}
