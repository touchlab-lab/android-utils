package co.touchlab.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 10/13/11
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractNotifyActivity extends Activity implements NotifyListener
{
    private NotifyProcessor notifyProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        notifyProcessor = new NotifyProcessor(this);
    }

    @Override
    protected void onResume()
    {
        notifyProcessor.registerNotify();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        notifyProcessor.unregisterNotify();
        super.onPause();
    }
}
