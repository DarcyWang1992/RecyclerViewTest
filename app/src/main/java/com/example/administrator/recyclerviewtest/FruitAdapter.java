package com.example.administrator.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/***
 * 因为FruitAdapter继承RecyclerView.Adapter必须重写onCreateViewHolder（），onBindViewHolder（），getItemCount（）这3个方法；
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    /**
     * 1、定义一个内部类ViewHolder，ViewHolder要继承自RecyclerView.ViewHolder
     * 2、ViewHolder的构造函数要传进一个View参数，这个参数就是RecyclerView子项最外层的布局
     */
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        View fruitView;
        public ViewHolder(View view){
            super(view);
            fruitView=view;
            imageView=view.findViewById(R.id.fruit_image);
            textView=view.findViewById(R.id.fruit_name);
        }
    }
    /***
     * FruitAdaper构造函数，用于把要展示的数据源传进来，并赋值给全局变量mFruitList
     * @param fruitList
     */
    public FruitAdapter( List<Fruit> fruitList) {
        mFruitList=fruitList;
    }

    /***
     * 用于创建ViewHolder实例，在这个方法中，将item布局加载进来并传入到构造函数中，最后将ViewHolder实例返回；
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
       final ViewHolder viewHolder=new ViewHolder(view);
       viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position=viewHolder.getAdapterPosition();
               Fruit fruit=mFruitList.get(position);
               Toast.makeText(parent.getContext(),"你点击了"+fruit.getName(),Toast.LENGTH_SHORT).show();
           }
       });
       viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position=viewHolder.getAdapterPosition();
               Fruit fruit=mFruitList.get(position);
               Toast.makeText(parent.getContext(),"你点击了"+fruit.getName(),Toast.LENGTH_SHORT).show();
           }
       });
        return viewHolder;
    }

    /***
     * 用于对RecyclerView的子项进行赋值，会在每个子项被滚到屏幕内执行
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit=mFruitList.get(position);
        holder.imageView.setImageResource(fruit.getImageid());
        holder.textView.setText(fruit.getName());
    }

    /***
     * 告诉RecyclerView有多少个子项
     * @return
     */
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }



}
