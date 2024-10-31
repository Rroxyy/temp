package com.roxy.homework3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData; // 存储适配器的数据
    private Context mContext; // 上下文对象

    // 构造方法，接收上下文和数据列表
    public MyAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 加载单个列表项的布局
        View view = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view); // 返回 ViewHolder 对象
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = mData.get(position); // 获取当前项数据
        holder.textView.setText(item); // 设置 TextView 的文本
        // 设置点击事件，当点击该项时跳转到相应的活动
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, getCorrespondingActivity(item)); // 创建意图
            mContext.startActivity(intent); // 启动活动
        });
    }

    @Override
    public int getItemCount() {
        return mData.size(); // 返回数据项的数量
    }

    // 根据项目名称返回对应的活动类
    private Class<?> getCorrespondingActivity(String item) {
        switch (item) {
            case "ArrayAdapterDemo":
                return ArrayAdapterDemo.class;
            case "BaseAdapterDemo":
                return BaseAdapterDemo.class;
            case "AutoCompleteTextViewDemo":
                return AutoCompleteTextViewDemo.class;
            case "RecyclerView":
                return RecyclerActivity.class;
            default:
                return null; // 默认返回 null
        }
    }

    // ViewHolder 内部类，持有每个列表项的视图组件
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView; // 列表项的 TextView

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1); // 初始化 TextView
        }
    }
}
