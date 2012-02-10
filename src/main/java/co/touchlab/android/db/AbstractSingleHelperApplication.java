package co.touchlab.android.db;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 8/26/11
 * Time: 2:09 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractSingleHelperApplication extends Application
{
    private SQLiteOpenHelper helper;

    public synchronized SQLiteOpenHelper getHelper()
    {
        if(helper == null)
            helper = loadHelper();

        return helper;
    }

    protected abstract SQLiteOpenHelper loadHelper();


}
