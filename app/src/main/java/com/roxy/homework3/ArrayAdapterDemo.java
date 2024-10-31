package com.roxy.homework3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ArrayAdapterDemo extends AppCompatActivity {

    private ListView sports_category_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_demo);

        // 初始化 ListView
        sports_category_list = findViewById(R.id.category_lv);

        // 从 strings.xml 中获取字符串数组
        String[] sports = getResources().getStringArray(R.array.sports_category);

        // 创建 ArrayAdapter 并设置数据
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                sports
        );

        // 将适配器绑定到 ListView
        sports_category_list.setAdapter(adapter);

        // 设置 ListView 项点击事件
        sports_category_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 显示点击的项目内容
                Toast.makeText(ArrayAdapterDemo.this, sports[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
