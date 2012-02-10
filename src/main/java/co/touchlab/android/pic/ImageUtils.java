package co.touchlab.android.pic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: kgalligan
 * Date: 10/11/11
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageUtils
{
    /**
     * Rough resize of image on Android.  Phones these days have HUGE image files coming in.  Gently resize.
     *
     * @param inFile
     * @param outFile
     * @param targetSize
     * @throws IOException
     */
    public static void targetResizeImage(File inFile, File outFile, int targetSize) throws IOException
    {
        //Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(new FileInputStream(inFile), null, o);

        //Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true)
        {
            if (width_tmp / 2 < targetSize || height_tmp / 2 < targetSize)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        if (scale == 1)
        {
            IOUtils.copyLarge(new FileInputStream(inFile), new FileOutputStream(outFile));
        }
        else
        {
            //Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;

            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(inFile));
            Bitmap sampled = BitmapFactory.decodeStream(bin, null, o2);
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(outFile));
            sampled.compress(Bitmap.CompressFormat.JPEG, 90, bout);

            bin.close();
            bout.flush();
            bout.close();
        }
    }

}
