package com.cxmax.robustdemo;

import android.content.Context;
import android.os.Environment;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchManipulate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @describe :
 * @usage :
 * <p>
 * <p>
 * Created by cxmax on 2017/8/29.
 */

public class PatchManipulateImp extends PatchManipulate {
    @Override
    protected List<Patch> fetchPatchList(Context context) {
        Patch patch = new Patch();
        patch.setName("test patch");
        patch.setLocalPath(Environment.getExternalStorageDirectory().getPath()
                + File.separator
                + "robust"
                + File.separator
                + "patch");

        //此处的类名要和 robust.xml 的 patchPackname 一致（可修改，但保持一致）
        //该类是用于替换 patch.jar 中被标注过注解地方的工具类
        patch.setPatchesInfoImplClassFullName("com.cxmax.robustdemo.patch.PatchesInfoImpl");
        List<Patch> patches = new ArrayList<>();
        patches.add(patch);
        return patches;
    }

    @Override
    protected boolean verifyPatch(Context context, Patch patch) {
        patch.setTempPath(context.getCacheDir()+ File.separator+"robust"+File.separator + "patch");
        try {
            copy(patch.getLocalPath(), patch.getTempPath());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("copy source patch to local patch error, no patch execute in path "+patch.getTempPath());
        }

        return true;
    }

    public void copy(String srcPath,String dstPath) throws IOException {
        File src=new File(srcPath);
        if(!src.exists()){
            throw new RuntimeException("source patch does not exist ");
        }
        File dst=new File(dstPath);
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs();
        }
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    @Override
    protected boolean ensurePatchExist(Patch patch) {
        return true;
    }
}
