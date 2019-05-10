package com.youdanhui.flutter_haopintui.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WeiXinShareUtil {

    /**
     * 微信分享到好友(单张图片及描述)
     *
     *
     * */
    public static void shareToWeiXinFriend(Context context, File file, String description) throws Exception {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_TEXT, description);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        context.startActivity(intent);
    }
    /**
     * 微信分享到好友(多张图片及描述)
     *
     *
     * */
    public static void shareMultiplePictureToFriend(Context context, List<File> files, String description) throws Exception {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        for (File f : files) {
            imageUris.add(Uri.fromFile(f));
        }
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        intent.putExtra(Intent.EXTRA_TEXT, description);
        context.startActivity(intent);
    }
    /**
     * 微信分享到朋友圈(单张图片及描述)
     *
     *
     * */
    public static void shareToWeiXinFriendGroup(Context context,File file,String description) throws Exception {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        intent.putExtra(Intent.EXTRA_TEXT, description);
        context.startActivity(intent);
    }
    /**
     * 微信分享到朋友圈(多张图片及描述)
     *
     *
     * */
    public static void shareMultiplePictureToTimeLine(Context context, List<File> files,String description) throws Exception {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        intent.setComponent(comp);
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");

        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        for (File f : files) {
            imageUris.add(Uri.fromFile(f));
        }
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        intent.putExtra(Intent.EXTRA_TEXT, description);
        context.startActivity(intent);
    }

}
