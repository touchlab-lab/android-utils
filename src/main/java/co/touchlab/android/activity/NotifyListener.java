package co.touchlab.android.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 10/13/11
 * Time: 1:39 AM
 * To change this template use File | Settings | File Templates.
 */
public interface NotifyListener
{
    String[] notifyStrings();
    void notifyEvent(Intent intent, String action);
    Intent registerReceiver(BroadcastReceiver rec, IntentFilter filter);
    void unregisterReceiver(BroadcastReceiver mExternalStorageReceiver);
}
