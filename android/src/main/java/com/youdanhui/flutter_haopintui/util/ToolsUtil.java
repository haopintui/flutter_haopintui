package com.youdanhui.flutter_haopintui.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

public class ToolsUtil {

    public static boolean isInstall(Context context,String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        // 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        // 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }

        return false;
    }

}
