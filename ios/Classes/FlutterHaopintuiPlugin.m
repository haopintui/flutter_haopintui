#import "FlutterHaopintuiPlugin.h"

@implementation FlutterHaopintuiPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"app.youadnhui.com/haopintui"
            binaryMessenger:[registrar messenger]];
  FlutterHaopintuiPlugin* instance = [[FlutterHaopintuiPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"getPlatformVersion" isEqualToString:call.method]) {
    result([@"iOS " stringByAppendingString:[[UIDevice currentDevice] systemVersion]]);
  }
  else if ([@"isInstall" isEqualToString:call.method]) {
      [self isInstall:call result:result];
  }
  else if ([@"openApp" isEqualToString:call.method]) {
//      NSString *scheme = call.arguments[@"scheme"];
//      NSString *packageName = call.arguments[@"packageName"];
//      NSString *url = call.arguments[@"url"];
//      NSDictionary *dic = @{@"scheme":scheme,@"packageName":packageName,@"url":url};
//      [self openApp:dic];
//      [self performSelector:@selector(openApp:) withObject:dic];
//      openApp(scheme packageName , );
      
//      result([@"iOS " stringByAppendingString:[[UIDevice currentDevice] systemVersion]]);
      [self openApp:call result:result];
//      result(@"success");
  }
  else {
    result(FlutterMethodNotImplemented);
  }
}

/** 判断是否安装了微信 */
-(void)isInstall:(FlutterMethodCall *)call result:(FlutterResult)result
{
    NSString *scheme = call.arguments[@"scheme"];
    NSString *packageName = call.arguments[@"packageName"];
    
    scheme = [scheme stringByAppendingString: @"://"];
    if ([[UIApplication sharedApplication] canOpenURL:[NSURL URLWithString:scheme]]){
        result(@(true));
    }else{
        result(@(false));
    }
}

-(void)openApp:(FlutterMethodCall *)call result:(FlutterResult)result
{
//    NSString *scheme = call.arguments[@"scheme"];
//    NSString *packageName = call.arguments[@"packageName"];
    NSString *url = call.arguments[@"url"];
    
//    NSString *scheme = nil;
//    NSString *packageName = nil;
//    NSString *url = nil;
//
//    if(urlParams[@"scheme"]){
//        scheme = urlParams[@"scheme"];
//    }
//    if(urlParams[@"packageName"]){
//        packageName = urlParams[@"packageName"];
//    }
//    if(urlParams[@"url"]){
//        url = urlParams[@"url"];
//    }
    
    if ([[UIApplication sharedApplication]
         canOpenURL:[NSURL URLWithString:url]])
    {
        bool openBool =  [[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];
        result(@{
         @"status":openBool?@"1":@"0"
        });
    }
    else
    {
//        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"URL error"
//                                                        message:[NSString stringWithFormat:
//                                                                 @"没有定义的访问连接%@", url]
//                                                       delegate:self cancelButtonTitle:@"Ok"
//                                              otherButtonTitles:nil];
//        [alert show];
        result(@{
         @"status":@"0"
        });
    }
}

@end
