package com.example.data;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Product;

public class AppData extends Application {

    public List<Product> selectedproduct=new ArrayList<>();                //用于存放已选小吃
    public double countprice;                                         //用于存放总价
    public String countremarks;                                       //用于存放总备注

    /**
     * 初始化方法
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
