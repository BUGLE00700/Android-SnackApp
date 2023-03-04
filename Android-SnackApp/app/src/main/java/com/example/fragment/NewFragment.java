package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.adapter.NewAdapter;
import com.example.xc.MainActivity3;
import com.example.xc.R;

public class NewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.new_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity3.initHomeBtnColor();
    }

    /**
     * 本方法作用实现RecyclerView + StaggeredGridLayout核心步骤
     * @param view 插入新品页面布局对象
     */
    private void initRecyclerView(View view){
        RecyclerView rv=view.findViewById(R.id.newRecycler);       //获得RecyclerView控件对象                                                                              														   //设置为StaggeredGridLayout流式布局
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));                                                                              														   //定义新品小吃图片数组
        int[] image={R.drawable.bf11,R.drawable.bf3,R.drawable.om1,R.drawable.om7,R.drawable.yc1,
                R.drawable.nf10,R.drawable.nf8};                                                                              														   //定义新品小吃说明数组
        String[] text={"嘎嘣脆香煎饼果子","鲜嫩多汁小笼包","薯条鸡肉丸组合","北欧蜜汁奶粉果",
                "什锦串串烤","川味凉面","自贡脆脆兔"};

        NewAdapter adapter=new NewAdapter(getActivity(),image,text); //调用适配器

        rv.setAdapter(adapter);                             //设置适配器到RecyclerView
    }
}
