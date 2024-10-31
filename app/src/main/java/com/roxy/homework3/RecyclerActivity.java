package com.roxy.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置活动的布局文件，加载 activity_recycler_view_demo.xml
        setContentView(R.layout.activity_recycler_view_demo);

        // 通过 ID 找到 RecyclerView 控件
        RecyclerView recyclerView = findViewById(R.id.recycler);
        // 设置 RecyclerView 的布局管理器为线性布局（垂直排列）
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 获取初始化的数据，数据是奥运金报的信息（图片、标题、详情）
        List<Map<String, Object>> data = initData();

        // 创建自定义适配器，将数据传递给 RecyclerView
        RecyclerAdapter adapter = new RecyclerAdapter(this, data);
        // 设置适配器，将 RecyclerAdapter 绑定到 RecyclerView
        recyclerView.setAdapter(adapter);
    }

    // 初始化数据的方法，返回一个包含奥运金报信息的列表
    private List<Map<String,Object>> initData(){
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();  // 创建存储数据的列表
        Map<String, Object> map;  // 每个列表项的数据以 Map 存储

        // 初始化第一个运动员数据：杨倩
        map = new HashMap<>();
        map.put("photo", R.drawable.yq);  // 图片资源
        map.put("title", "杨倩绝杀女子10米气步枪");  // 标题
        map.put("detail", "中国00后运动员杨倩最后一枪绝杀，为中国代表团射落东京奥运会的首枚金牌。");  // 详情
        data.add(map);  // 将数据添加到列表中

        // 初始化第二个运动员数据：侯志慧
        map = new HashMap<>();
        map.put("photo", R.drawable.j2);
        map.put("title", "侯志慧女子举重49公斤级夺冠");
        map.put("detail", "在2020年奥运会女子举重49公斤级比赛中，侯志慧以总成绩210kg获得冠军。");
        data.add(map);

        // 初始化第三个运动员数据：孙一文
        map = new HashMap<>();
        map.put("photo", R.drawable.j3);
        map.put("title", "孙一文女子重剑夺中国第三金");
        map.put("detail", "女子重剑个人赛，孙一文以11比10击败罗马尼亚选手波佩斯库，获得冠军。");
        data.add(map);

        // 初始化第四个运动员数据：施廷懋/王涵
        map = new HashMap<>();
        map.put("photo", R.drawable.j4);
        map.put("title", "跳水女子三米板施廷懋王涵夺冠");
        map.put("detail", "中国跳水队施廷懋/王涵发挥稳定，她们一路领先以326.40分夺得冠军。");
        data.add(map);

        // 初始化第五个运动员数据：李发彬
        map = new HashMap<>();
        map.put("photo", R.drawable.j5);
        map.put("title", "举重男子61公斤级李发彬夺冠");
        map.put("detail", "举重男子61公斤级，李发彬以抓举141公斤，挺举172公斤，获得金牌。");
        data.add(map);

        // 初始化第六个运动员数据：谌利军
        map = new HashMap<>();
        map.put("photo", R.drawable.j6);
        map.put("title", "大力士谌利军举重67公斤级夺冠");
        map.put("detail", "男子67公斤级比赛，中国选手谌利军最终以332公斤获得冠军.");
        data.add(map);

        // 初始化第七个运动员数据：姜冉馨/庞伟
        map = new HashMap<>();
        map.put("photo", R.drawable.j7);
        map.put("title", "十米气手枪混双姜冉馨/庞伟夺金");
        map.put("detail", "气手枪混合团体决赛姜冉馨/庞伟，连续逆转，最后一枪绝杀对手夺金.");
        data.add(map);

        // 初始化第八个运动员数据：陈芋汐/张家齐
        map = new HashMap<>();
        map.put("photo", R.drawable.j8);
        map.put("title", "女子十米台陈芋汐/张家齐夺金");
        map.put("detail", "陈芋汐/张家齐在女子双人10米台上一路领先，以363.78分夺取金牌。");
        data.add(map);

        // 初始化第九个运动员数据：双杨组合
        map = new HashMap<>();
        map.put("photo", R.drawable.j9);
        map.put("title", "双杨组合射落气步枪混团金牌");
        map.put("detail", "杨倩/杨皓然在气步枪混团决赛里以17比13战胜美国对手夺冠，取得中国第9金.");
        data.add(map);

        // 初始化第十个运动员数据：女子四人双桨
        map = new HashMap<>();
        map.put("photo", R.drawable.j10);
        map.put("title", "女子四人双桨决赛中国赛艇夺金");
        map.put("detail", "中国陈云霞/张灵/吕扬/崔晓桐划出6分05秒13的成绩，获得该项目金牌。");
        data.add(map);

        return data;  // 返回包含所有数据的列表
    }

}
