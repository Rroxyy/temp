package com.roxy.homework3;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

// 自定义适配器类，继承自 RecyclerView.Adapter，管理数据和视图的绑定
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Map<String, Object>> mData; // 数据源，存储奥运金报的内容
    private LayoutInflater mInflater; // 用于加载布局的 LayoutInflater

    // 构造函数，初始化适配器，传入上下文和数据
    public RecyclerAdapter(Context context, List<Map<String, Object>> data) {
        this.mData = data; // 赋值数据源
        this.mInflater = LayoutInflater.from(context); // 初始化 LayoutInflater
    }

    // 创建 ViewHolder，用于缓存视图，避免频繁的 findViewById 操作
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 加载卡片布局 cardview_bt.xml，并创建 ViewHolder
        View view = mInflater.inflate(R.layout.cardview_bt, parent, false);
        return new ViewHolder(view); // 返回 ViewHolder
    }

    // 绑定数据到 ViewHolder 中的控件
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 获取当前数据项
        Map<String, Object> item = mData.get(position);

        // 设置图片、标题和详细信息
        holder.album_thumb.setImageResource((Integer) item.get("photo")); // 设置新闻图片
        holder.album_title.setText((String) item.get("title")); // 设置新闻标题
        holder.album_info.setText((String) item.get("detail")); // 设置新闻详情

        // 初始化计数器，初始值为 0
        holder.counter.setText("0");

        // 设置按钮点击事件，点击后计数器加 1
        holder.album_btn.setOnClickListener(v -> {
            // 获取当前计数器的值，并加 1
            int count = Integer.parseInt(holder.counter.getText().toString());
            count++;
            holder.counter.setText(String.valueOf(count)); // 更新计数器显示
            // 显示 Toast 提示，包含标题和详情
            Toast.makeText(v.getContext(), (String) item.get("title") + "\n" + (String) item.get("detail"), Toast.LENGTH_SHORT).show();
        });

        // 设置点击事件，点击详情文字后显示对话框
        holder.album_info.setOnClickListener(v -> {
            // 显示一个对话框，包含新闻的标题和详细信息
            new AlertDialog.Builder(v.getContext())
                    .setTitle((String) item.get("title")) // 对话框标题为新闻标题
                    .setMessage((String) item.get("detail")) // 对话框内容为新闻详情
                    .setPositiveButton("确定", null) // 确定按钮
                    .create()
                    .show();
        });
    }

    // 返回数据集的大小
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 内部类 ViewHolder，用于缓存控件
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 定义控件
        ImageView album_thumb; // 新闻图片
        TextView album_title; // 新闻标题
        TextView album_info; // 新闻详情
        ImageButton album_btn; // 点赞按钮
        TextView counter; // 点赞计数器

        // 构造函数，绑定控件
        public ViewHolder(View itemView) {
            super(itemView);
            album_thumb = itemView.findViewById(R.id.album_thumb); // 绑定新闻图片
            album_title = itemView.findViewById(R.id.album_title); // 绑定新闻标题
            album_info = itemView.findViewById(R.id.album_info); // 绑定新闻详情
            album_btn = itemView.findViewById(R.id.album_btn); // 绑定点赞按钮
            counter = itemView.findViewById(R.id.counter); // 绑定点赞计数器
        }
    }
}
