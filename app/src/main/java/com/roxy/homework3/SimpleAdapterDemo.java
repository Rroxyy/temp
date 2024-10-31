package com.roxy.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterDemo extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_demo);

        /****补充
         * 
         * 
         * 
         * 
         * 
         * 
         * ***/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view.findViewById(R.id.detail);
                Toast.makeText(SimpleAdapterDemo.this,tv.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        //创建一个Imageview作为listView的header View
        ImageView iv = new ImageView(this);
        iv.setBackgroundResource(R.drawable.header);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                240
        );
        iv.setLayoutParams(lp);
        listView.addHeaderView(iv);

        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

    }

    private List<Map<String,Object>> initData(){
        List<Map<String,Object>> data = new ArrayList<Map<String, Object>>();
        Map  map;
        map = new HashMap();
        map.put("photo",R.drawable.yq);
        map.put("title","杨倩绝杀女子10米气步枪");
        map.put("detail","中国00后运动员杨倩最后一枪绝杀，为中国代表团射落东京奥运会的首枚金牌。");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j2);
        map.put("title","侯志慧女子举重49公斤级夺冠");
        map.put("detail","在2020年奥运会女子举重49公斤级比赛中，侯志慧以总成绩210kg获得冠军。");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j3);
        map.put("title","孙一文女子重剑夺中国第三金");
        map.put("detail","女子重剑个人赛，孙一文以11比10击败罗马尼亚选手波佩斯库，获得冠军。");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j4);
        map.put("title","跳水女子三米板施廷懋王涵夺冠");
        map.put("detail","中国跳水队施廷懋/王涵发挥稳定，她们一路领先以326.40分夺得冠军。");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j5);
        map.put("title","举重男子61公斤级李发彬夺冠");
        map.put("detail","举重男子61公斤级，李发彬以抓举141公斤，挺举172公斤，获得金牌。");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j6);
        map.put("title","大力士谌利军举重67公斤级夺冠");
        map.put("detail","男子67公斤级比赛，中国选手谌利军最终以332公斤获得冠军.");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j7);
        map.put("title","十米气手枪混双姜冉馨/庞伟夺金");
        map.put("detail","气手枪混合团体决赛姜冉馨/庞伟，连续逆转，最后一枪绝杀对手夺金.");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j8);
        map.put("title","女子十米台陈芋汐/张家齐夺金");
        map.put("detail","陈芋汐/张家齐在女子双人10米台上一路领先，以363.78分夺取金牌。");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j9);
        map.put("title","双杨组合射落气步枪混团金牌");
        map.put("detail","杨倩/杨皓然在气步枪混团决赛里以17比13战胜美国对手夺冠，取得中国第9金.");
        data.add(map);
        map = new HashMap();
        map.put("photo",R.drawable.j10);
        map.put("title","女子四人双桨决赛中国赛艇夺金");
        map.put("detail","中国陈云霞/张灵/吕扬/崔晓桐划出6分05秒13的成绩，获得该项目金牌。");
        data.add(map);

        return data;

    }
}
