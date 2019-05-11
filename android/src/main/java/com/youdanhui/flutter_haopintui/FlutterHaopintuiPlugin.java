package com.youdanhui.flutter_haopintui;

import android.content.Intent;
import android.net.Uri;

import com.youdanhui.flutter_haopintui.util.ToolsUtil;

import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterHaopintuiPlugin */
public class FlutterHaopintuiPlugin implements MethodCallHandler {
  public static FlutterHaopintuiPlugin instance;
  private static Registrar registrar;
  public final MethodChannel channel;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
//    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_haopintui");
//    channel.setMethodCallHandler(new FlutterHaopintuiPlugin());
    instance = new FlutterHaopintuiPlugin(registrar);
  }

  private FlutterHaopintuiPlugin(Registrar registrar) {
    FlutterHaopintuiPlugin.registrar = registrar;
    MethodChannel channel = new MethodChannel(registrar.messenger(), "app.youadnhui.com/haopintui");
    channel.setMethodCallHandler(this);
    this.channel = channel;
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    else if(call.method.equals("isInstall")){
      isInstall(call,result);
    }
    else if(call.method.equals("openApp")){
//      String url = call.argument("url");
//      String packageName = call.argument("packageName");
      openApp(call,result);
//      result.success("success");
    }
    else {
      result.notImplemented();
    }
  }


  public void isInstall(MethodCall call, Result result) {
    String packageName = call.argument("packageName");
    result.success(ToolsUtil.isInstall(registrar.activeContext(),packageName));
  }

  public void openApp(MethodCall call, Result result){
    String url = call.argument("url");
    String packageName = call.argument("packageName");

    Intent action = new Intent(Intent.ACTION_VIEW);
//    Intent action = registrar.activity().getIntent();
    action.setPackage(packageName);

//        action.setAction(Intent.ACTION_MAIN);
//        action.addCategory(Intent.CATEGORY_LAUNCHER);
    action.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
    StringBuilder builder = new StringBuilder();
    builder.append(url);
    action.setData(Uri.parse(builder.toString()));
    registrar.activity().startActivityForResult(action,0);

    Map<String,String> data = new HashMap<String,String>();
    data.put("status" , "1");
    result.success(data);

//        PackageManager packageManager = context.getPackageManager();
//        StringBuilder builder = new StringBuilder();
//        builder.append(url);
//        Intent intent = packageManager.getLaunchIntentForPackage(packageName);
//        intent.setAction("com.xunmeng.pinduoduo");
//
//        intent.setData(Uri.parse(builder.toString()));
//        context.startActivityForResult(intent,0);

//        Intent action = new Intent(context, BaichuanActivity.class);
//        action.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
//        action.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
////        context.startActivityForResult(action,0);
//
//        onActivityResult(0,0,action);



//        Intent intent = new Intent(this, SecondActivity.class);

//        new BaichuanActivity().startActivityForResult(action,0);
//        this.onActivityResult(0,0,action);


//        context.startActivity(intent);
//        Intent intent =  new Intent(MainActivity.this,ToStartActivity.class);

//    return true;

//        ((Activity) (mWXSDKInstance.getContext())).startActivity(action);

//        ((Activity) (mWXSDKInstance.getContext())).startActivityForResult(new Intent(Intent.ACTION_PICK),0);

  }

}
