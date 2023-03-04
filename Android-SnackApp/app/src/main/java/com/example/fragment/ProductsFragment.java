package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.ProductLeftAdapter;
import com.example.adapter.ProductRightAdapter;
import com.example.xc.MainActivity3;
import com.example.xc.R;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Product;

public class ProductsFragment extends Fragment {
    public static List<List<Product>> list=new ArrayList<>();  //定义存放右边列表所有选项数据的集合
    public static RecyclerView rightrv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.products_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity3.initProductBtnColor();
    }

    /**
     * 本方法用于实现左右列表核心功能实现
     * @param view 传入点菜页面布局对象
     */
    private void initRecyclerView(View view){
        RecyclerView leftrv=view.findViewById(R.id.leftRecycler);   //获得左边列表控件对象
                                                                    // 设置为上下结构的LinearLayout布局
        leftrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
                                                                    //小吃分类名
        String[] classname={"南方小吃","北方小吃","原创小吃","亚洲小吃","欧美小吃"};
                                                                    //调用左边列表适配器类
        ProductLeftAdapter leftAdapter=new ProductLeftAdapter(getActivity(),classname);
        leftrv.setAdapter(leftAdapter);                             //把适配器设置给左边列表控件
                                                                    //定义5组小吃图片
        int[] nfimage={R.drawable.nf1,R.drawable.nf2,R.drawable.nf3,R.drawable.nf4,R.drawable.nf5,R.drawable.nf6,
                R.drawable.nf7,R.drawable.nf8,R.drawable.nf9,R.drawable.nf10,R.drawable.nf11};
        int[] bfimage={R.drawable.bf1,R.drawable.bf2,R.drawable.bf3,R.drawable.bf4,R.drawable.bf5,R.drawable.bf6,
                R.drawable.bf7,R.drawable.bf8,R.drawable.bf9,R.drawable.bf10,R.drawable.bf11};
        int[] ycimage={R.drawable.yc1,R.drawable.yc2,R.drawable.yc3,R.drawable.yc4,R.drawable.yc5,R.drawable.yc6,
                R.drawable.yc7,R.drawable.yc8,R.drawable.yc9,R.drawable.yc10};
        int[] yzimage={R.drawable.yz1,R.drawable.yz2,R.drawable.yz3,R.drawable.yz4,R.drawable.yz5,R.drawable.yz6,
                R.drawable.yz7,R.drawable.yz8,R.drawable.yz9,R.drawable.yz10,R.drawable.yz11,};
        int[] omimage={R.drawable.om1,R.drawable.om2,R.drawable.om3,R.drawable.om4,R.drawable.om5,
                R.drawable.om6,R.drawable.om7,R.drawable.om8,R.drawable.om9,R.drawable.om10,};
                                                                    //定义5组小吃名称
        String[] nfname={"南方小吃1","南方小吃2","南方小吃3","南方小吃4","南方小吃5","南方小吃6",
                "南方小吃7","南方小吃8","南方小吃9","南方小吃10","南方小吃11"};
        String[] bfname={"北方小吃1","北方小吃2","北方小吃3","北方小吃4","北方小吃5","北方小吃6",
                "北方小吃7","北方小吃8","北方小吃9","北方小吃10","北方小吃11"};
        String[] ycname={"原创小吃1","原创小吃2","原创小吃3","原创小吃4","原创小吃5","原创小吃6",
                "原创小吃7","原创小吃8","原创小吃9","原创小吃10"};
        String[] yzname={"亚洲小吃1","亚洲小吃2","亚洲小吃3","亚洲小吃4","亚洲小吃5","亚洲小吃6",
                "亚洲小吃7","亚洲小吃8","亚洲小吃9","亚洲小吃10","亚洲小吃11"};
        String[] omname={"欧美小吃1","欧美小吃2","欧美小吃3","欧美小吃4","欧美小吃5","欧美小吃6",
                "欧美小吃7","欧美小吃8","欧美小吃9","欧美小吃10"};
                                                                    //定义5组小吃价格
        String[] nfprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] bfprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] ycprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};
        String[] yzprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5","8.0"};
        String[] omprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};

                                                                    //获取南方小吃分类数据，并添加的集合里。
        List<Product>  listright1=getList(nfimage, nfname, nfprice);
        list.add(listright1);
                                                                    //获取北方小吃分类数据，并添加的集合里。
        List<Product>  listright2=getList(bfimage, bfname, bfprice);
        list.add(listright2);
                                                                    //获取原创小吃分类数据，并添加的集合里。
        List<Product>  listright3=getList(ycimage, ycname, ycprice);
        list.add(listright3);
                                                                    //获取亚洲小吃分类数据，并添加的集合里。
        List<Product>  listright4=getList(yzimage, yzname, yzprice);
        list.add(listright4);
                                                                    //获取欧美小吃分类数据，并添加的集合里。
        List<Product>  listright5=getList(omimage, omname, omprice);
        list.add(listright5);

        rightrv=view.findViewById(R.id.rightRecycler);               //获得右边列表控件对象
                                                                    //设置为上下结构的LinearLayout布局
        rightrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
                                                                    //调用右边列表适配器类
        ProductRightAdapter rightAdapter=new ProductRightAdapter(getActivity(),listright1);

        rightrv.setAdapter(rightAdapter);                          //把适配器设置给右边列表控件
    }

    /**
     * 本方法用于生成右边列表选项数据集合
     * @param iamges 传入一组小吃图片
     * @param names 传入一组小吃名称
     * @param prices 传入一组小吃价格
     * @return 返回一个分类的所有小吃数据集合
     */
    public List<Product> getList(int[] iamges, String[] names, String[] prices){
        List<Product>  listright=new ArrayList<>();                 //存放右边列表所有数据
        Product product;                                      //用于存放一个选项数据
        for(int i=0;i<iamges.length;i++){
            product=new Product();
            product.setImage(iamges[i]);
            product.setName(names[i]);
            product.setPrice(prices[i]);
            listright.add(product);
        }
        return listright;
    }
}
