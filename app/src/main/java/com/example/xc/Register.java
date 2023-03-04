package com.example.xc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.BaseUrl;
import com.example.MyCallBack;
import com.example.net.OkhttpUtils;

public class Register extends AppCompatActivity {

    private EditText et_loginname;
    private EditText et_password;
    private EditText et_name;
    private EditText et_telephone;
    private Button btn_register;
    private Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();
    }

    private void initView() {
        et_loginname = findViewById(R.id.et_loginname);
        et_password = findViewById(R.id.et_password);
        et_name = findViewById(R.id.et_name);
        et_telephone = findViewById(R.id.et_telephone);
        btn_register = findViewById(R.id.btn_register);
        btn_reset = findViewById(R.id.btn_reset);
    }

    private void initEvent() {

        //重置按钮
        btn_reset.setOnClickListener((view -> {
            et_loginname.setText("");
            et_password.setText("");
            et_name.setText("");
            et_telephone.setText("");

        }));

        btn_register.setOnClickListener(view -> {

            String loginname = String.valueOf(et_loginname.getText());
            String password = String.valueOf(et_password.getText());
            String name = String.valueOf(et_name.getText());
            String telephone = String.valueOf(et_telephone.getText());

            OkhttpUtils.getInstance().doGet(BaseUrl.REGISTER_URL+"?loginname="+loginname+
                            "&password="+password+"&name="+name+"&telephone="+telephone,
                    new MyCallBack() {
                @Override
                public void onSuccess(String result) {

//                    Log.d("ning",result);
                    if(result.equals("true")){

                        //创建意图对象
//                        Intent intent = new Intent();
//                        intent.setClass(Register.this, MainActivity.class);
//                        //跳转
//                        startActivity(intent);
                        Toast.makeText(Register.this,"注册成功",Toast.LENGTH_LONG).show();
                        finish();

                    }else{
                        Toast.makeText(Register.this,result,Toast.LENGTH_LONG).show();

                    }

                }

                @Override
                public Void onError(Exception e) {
                    Toast.makeText(Register.this,"网络出错",Toast.LENGTH_LONG).show();
                    return null;
                }
            });
        });

    }
}