import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'package:flutter_haopintui/src/sdk.dart';

final MethodChannel _channel = const MethodChannel('app.youadnhui.com/haopintui');


Future<String> gePlatformVersion() async {
  // final String version = await _channel.invokeMethod('getPlatformVersion');
  // return version;
  return await _channel.invokeMethod("getPlatformVersion");
}

Future<String> get platformVersion async {
  final String version = await _channel.invokeMethod('getPlatformVersion');
  return version;
}

Future<bool> isInstall({String scheme,
  String packageName,
  }) async {
    Map des = {
    "scheme": scheme,
    "packageName": packageName
  };
  return await _channel.invokeMethod("isInstall", des);
}

Future<OpenResult> openApp({@required String url,
  String scheme,
  String packageName,
  }) async {
  assert(url != null );

  Map des = {
    "url": url,
    "scheme": scheme,
    "packageName": packageName
  };

  Map result = await _channel.invokeMethod("openApp", des);
  return OpenResult(
    status: result["status"]
  );
}