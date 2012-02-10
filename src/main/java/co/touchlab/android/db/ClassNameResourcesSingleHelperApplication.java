package co.touchlab.android.db;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 8/26/11
 * Time: 3:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ClassNameResourcesSingleHelperApplication extends AbstractClassSingleHelperApplication
{

    @Override
    protected Class loadClass()
    {
        int id = getResources().getIdentifier("open_helper_classname", "string", getPackageName());
        if (id == 0) {
            throw new IllegalStateException("string resrouce open_helper_classname required");
        }

        String className = getResources().getString(id);

        try
        {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
