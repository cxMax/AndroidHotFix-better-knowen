package com.cxmax.hotpath;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @describe :
 * @usage :
 * <p>
 * </p>
 * Created by caixi on 18-2-3.
 */

public class AssetsUtil {

    public static void copyAssets(Context context, String assetsName, String destFilePath) throws IOException {
        File file = new File(destFilePath);
        FileOutputStream out =  new FileOutputStream(file);

        InputStream in = context.getAssets().open(assetsName);

        byte[] buf = new byte[1024];
        int len;
        while ((len= in.read(buf)) != -1) {
            out.write(buf,0,len);
        }
        in.close();
        out.close();
    }

}
