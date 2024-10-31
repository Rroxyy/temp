package com.roxy.homework3;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 定义适配器和数据列表
    private MyAdapter myAdapter;
    private List<String> itemList; // 原始项目列表
    private List<String> filteredList; // 过滤后的项目列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout); // 设置布局

        // 获取 RecyclerView 和 SearchView 的引用
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        SearchView searchView = findViewById(R.id.searchView);

        // 初始化原始项目列表，并添加示例数据
        itemList = new ArrayList<>();
        itemList.add("ArrayAdapterDemo");
        itemList.add("BaseAdapterDemo");
        itemList.add("AutoCompleteTextViewDemo");
        itemList.add("RecyclerView");

        // 将原始列表复制给过滤列表
        filteredList = new ArrayList<>(itemList);

        // 创建适配器并设置给 RecyclerView
        myAdapter = new MyAdapter(this, filteredList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // 设置布局管理器
        recyclerView.setAdapter(myAdapter); // 设置适配器

        // 为 SearchView 设置查询文本监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false; // 不需要处理提交的查询
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText); // 当查询文本改变时调用过滤方法
                return true;
            }
        });
    }

    // 过滤列表的方法
    private void filter(String text) {
        filteredList.clear(); // 清空过滤后的列表
        if (text.isEmpty()) {
            // 如果搜索框为空，恢复显示所有项目
            filteredList.addAll(itemList);
        } else {
            // 否则根据输入文本过滤项目
            for (String item : itemList) {
                if (item.toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item); // 添加匹配的项目
                }
            }
        }
        myAdapter.notifyDataSetChanged(); // 通知适配器数据已更改
    }
}
