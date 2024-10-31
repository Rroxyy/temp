package com.roxy.homework3;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

public class AutoCompleteTextViewDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete);

        // 获取 AutoCompleteTextView 控件
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        // 数据源
        String[] schools = {
                "湖南大学", "湖南师范大学", "湖南工商大学",
                "湖南科技大学", "湖南工程学院", "湖南农业大学",
                "湖南中医药大学", "湖南工业大学", "湖南理工学院"
        };

        // 创建 ArrayAdapter，并设置到 AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                schools
        );

        autoCompleteTextView.setAdapter(adapter);

        // 设置输入2个字符后开始显示建议  湖南
        autoCompleteTextView.setThreshold(2);
    }
}
