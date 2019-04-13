import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_haopintui/flutter_haopintui.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_haopintui');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterHaopintui.platformVersion, '42');
  });
}
