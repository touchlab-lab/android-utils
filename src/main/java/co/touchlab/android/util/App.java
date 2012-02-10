package co.touchlab.android.util;

import android.util.Log;


/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 7/21/11
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class App
{
    final static String TAG = App.class.getName();
    public static final boolean DEBUG = false;

    public static void logDebug(String TAG, String msg)
    {
        Log.d(TAG, msg);
    }

    public static void log(String msg)
    {
        Log.i(TAG, msg);
    }

    public static void logException(String msg, Throwable t)
    {
        Log.e(TAG, msg, t);
    }

    public static void logException(String msg)
    {
        Log.e(TAG, msg);
    }

    public static void logException(Throwable e)
    {
        Log.e(TAG, "", e);
    }
}
