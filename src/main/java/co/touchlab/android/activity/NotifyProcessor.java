package co.touchlab.android.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 10/13/11
 * Time: 1:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class NotifyProcessor
{
    private NotifyListener notifyListener;
    Collection<BroadcastReceiver> mExternalStorageReceivers;

    public NotifyProcessor(NotifyListener notifyListener)
    {
        this.notifyListener = notifyListener;
    }

    synchronized void registerNotify()
    {
        String[] notifys = notifyListener.notifyStrings();

        if (mExternalStorageReceivers == null && notifys != null)
        {
            mExternalStorageReceivers = new ArrayList<BroadcastReceiver>(notifys.length);
            for (final String action : notifys)
            {
                BroadcastReceiver rec = new BroadcastReceiver()
                {
                    @Override
                    public void onReceive(Context context, Intent intent)
                    {
                        notifyListener.notifyEvent(intent, action);
                    }
                };
                IntentFilter filter = new IntentFilter(action);

                notifyListener.registerReceiver(rec, filter);
                mExternalStorageReceivers.add(rec);
            }
        }
    }

    synchronized void unregisterNotify()
    {
        if (mExternalStorageReceivers != null)
        {
            for (BroadcastReceiver mExternalStorageReceiver : mExternalStorageReceivers)
            {
                notifyListener.unregisterReceiver(mExternalStorageReceiver);
            }
        }

        mExternalStorageReceivers = null;
    }
}
