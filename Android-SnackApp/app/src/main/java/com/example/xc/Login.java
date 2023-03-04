package com.example.xc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.BaseUrl;
import com.example.MyCallBack;
import com.example.net.OkhttpUtils;

public class Login extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initEvent();
    }


//初始化控件
    private void initView() {
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);
    }

    private void initEvent() {

        btn_login.setOnClickListener(view -> {
            String username = String.valueOf(et_username.getText());
            String password = String.valueOf(et_password.getText());

//            Log.d("ning","账号："+username+"密码："+ password);
            OkhttpUtils.getInstance().doGet(BaseUrl.LOGIN_URL+"?loginname="+username+"&password="+password, new MyCallBack() {
                @Override
                public void onSuccess(String result) {

//                    Log.d("ning",result);
                    if(result.equals("true")){
                        //创建意图对象
                        Intent intent = new Intent();
                        intent.setClass(Login.this, MainActivity3.class);
                        //跳转
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this,result,Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public Void onError(Exception e) {
                    Toast.makeText(Login.this,"网络出错",Toast.LENGTH_LONG).show();
                    return null;
                }
            });

        });

        btn_register.setOnClickListener(view -> {
            //创建意图对象
            Intent intent = new Intent();
            intent.setClass(Login.this, Register.class);
            //跳转
            startActivity(intent);
        });
    }
}