package com.example.mybluetooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class DialActivity extends AppCompatActivity {
    ImageView exit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //声明使用自定义标题
        setContentView(R.layout.dial_pad);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        exit_btn = (ImageView) findViewById(R.id.exit_dial);  //退出拨号盘
        exit_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Intent myIntent = new Intent();
                    setResult(0,myIntent);
                    finish();
                }
                return true;
            }
        });
    }
}
