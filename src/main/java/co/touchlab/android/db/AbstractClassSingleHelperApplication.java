package co.touchlab.android.db;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 8/26/11
 * Time: 3:38 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractClassSingleHelperApplication extends AbstractSingleHelperApplication
{
    @Override
    protected SQLiteOpenHelper loadHelper()
    {
        try
        {
            return (SQLiteOpenHelper) loadClass().newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    protected abstract Class loadClass();
}
