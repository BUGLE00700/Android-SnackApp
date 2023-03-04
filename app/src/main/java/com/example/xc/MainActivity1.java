package com.example.xc;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

//        //通过id获取控件
//        TextView tv_aaa = findViewById(R.id.tv_aaa);
//        //设置文本内容
//        tv_aaa.setText("你好");
//        //设置字体大小
//        tv_aaa.setTextSize(50);
//        //设置字体颜色
//        tv_aaa.setTextColor(Color.RED);
//
//
//        //通过id获取按钮
//        Button btn_a = findViewById(R.id.btn_a);
//
//        //设置点击事件
//        btn_a.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //创建意图对象
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, MainActivity2.class);
//                //跳转
//                startActivity(intent);
//            }
//        });
    }
}