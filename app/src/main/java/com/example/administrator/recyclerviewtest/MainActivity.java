package com.example.administrator.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/***
 * RecyclerView的基本用法
 */
public class MainActivity extends AppCompatActivity {
    private String [] data={"Apple","banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
            "Apple","banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};
    private List<Fruit> list;

    /**
     * LinearLayoutManager用于指定RecyclerView的布局方式，调用LinearLayoutManager的setOrientation（）方法来设置布局的排列方向，默认是纵向排列
     * LinearLayoutManager.HORIZONTAL让布局横向排列
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        //瀑布流,创建一个StaggeredGridLayoutManager实例，StaggeredGridLayoutManager的构造函数有两个参数
        //第一个用于指定布局的列数，第二个指定布局的排列方向。
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter=new FruitAdapter(list);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruit() {
        list=new ArrayList<>();
        for (int i=0;i<data.length;i++){
            Fruit fruit=new Fruit(data[i],R.mipmap.ic_launcher);
            list.add(fruit);
        }
    }
}
