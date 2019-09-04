package com.chx.wxpay.wxpayutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tencent.mm.opensdk.openapi.IWXAPI;

public class MainActivity extends AppCompatActivity {

    /**
     *
     IWXAPI api;
     PayReq request = new PayReq();
     request.appId = "wxd930ea5d5a258f4f";   应用ID
     request.partnerId = "1900000109";       商户号
     request.prepayId= "1101000000140415649af9fc314aa427",;     预支付交易会话ID
     request.packageValue = "Sign=WXPay";                   扩展字段
     request.nonceStr= "1101000000140429eb40476f8896f4c9";  随机字符串
     request.timeStamp= "1398746574";                   时间戳
     request.sign= "7FFECB600D7157C5AA49810D2D8F28BC2811827B";      签名
     api.sendReq(request);

     返回结果
     名称	描述	解决方案
     0	成功	展示成功页面
     -1	错误	可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、
                其他异常等。
     -2	用户取消	无需处理。发生场景：用户不支付了，点击取消，返回APP。
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在服务端签名
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //假装请求了服务器 获取到了所有的数据,注意参数不能少
                WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
                builder.setAppId("123")
                        .setPartnerId("56465")
                        .setPrepayId("41515")
                        .setPackageValue("5153")
                        .setNonceStr("5645")
                        .setTimeStamp("56512")
                        .setSign("54615")
                        .build().toWXPayNotSign(MainActivity.this);
            }
        });
        //在客户端签名
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //假装请求了服务端信息，并获取了appid、partnerId、prepayId，注意参数不能少
                WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
                builder.setAppId("123")
                        .setPartnerId("213")
                        .setPrepayId("3213")
                        .setPackageValue("Sign=WXPay")
                        .build()
                        .toWXPayAndSign(MainActivity.this,"123","key");
            }
        });
    }
}
