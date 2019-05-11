import 'dart:async';

import 'package:flutter/services.dart';

class FlutterHaopintui {
  static const MethodChannel _channel = const MethodChannel('app.youadnhui.com/flutter_haopintui');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

}
