package com.roxy.homework3;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义适配器类，继承自 BaseAdapter，用于将数据绑定到 ListView 中。
 * 每个列表项展示运动员的图片、标题和详情信息。
 * 支持点击详情文本显示详细信息弹窗。
 */
public class MyBaseAdapter extends BaseAdapter {

    // 上下文，用于获取系统资源和服务，例如 LayoutInflater。
    private Context context;

    // 用于存储每个列表项的数据，包含图片资源、标题、详细信息等。
    private List<Map<String, Object>> listItems;

    // 布局填充器，用于将 XML 布局文件转换为 View 对象。
    private LayoutInflater listContainer;

    // 用于存储 CheckBox 的选中状态，Key 为列表项位置，Value 为是否选中。
    public Map<Integer, Boolean> cbxFlag = null;

    /**
     * ViewHolder 内部类，用于存储列表项视图中的控件，避免重复调用 findViewById。
     */
    public class ViewHolder {
        public ImageView photo;  // 显示运动员照片的 ImageView
        public TextView title;   // 显示标题的 TextView
        public TextView detail;  // 显示详情的 TextView
    }

    /**
     * 构造函数，初始化适配器。
     *
     * @param context  上下文对象，通常是 Activity
     * @param listItems  包含每个列表项数据的 List，数据以 Map 的形式存储
     */
    public MyBaseAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        this.listContainer = LayoutInflater.from(context);  // 初始化布局填充器
        this.listItems = listItems;  // 绑定数据源
        cbxFlag = new HashMap<>();   // 初始化 CheckBox 状态存储 Map
        init();  // 初始化 CheckBox 状态
    }

    /**
     * 初始化 CheckBox 状态，将所有列表项的 CheckBox 设置为未选中状态。
     */
    private void init() {
        for (int i = 0; i < listItems.size(); i++) {
            cbxFlag.put(i, false);  // 默认所有 CheckBox 状态为未选中
        }
    }

    /**
     * 返回列表项的总数。

     */
    @Override
    public int getCount() {
        return listItems.size();
    }

    /**
     * 返回指定位置的列表项数据。
     *
     */
    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    /**
     * 返回指定位置的列表项 ID，一般为位置索引。
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 检查指定位置的 CheckBox 是否被选中。
     */
    public boolean hasChecked(int position) {
        return cbxFlag.get(position);
    }

    /**
     * 获取列表项的视图，并将数据绑定到视图上。
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int selectId = position;  // 当前选择的列表项位置
        ViewHolder holder = null;  // 用于存储列表项的视图控件

        // 如果 convertView 为空，说明该视图还未创建，需要初始化
        if (convertView == null) {
            holder = new ViewHolder();  // 创建 ViewHolder 对象
            // 将自定义的列表项布局文件 listview_item.xml 转换为 View 对象
            convertView = listContainer.inflate(R.layout.listview_item, parent, false);

            // 初始化 ViewHolder 中的控件
            holder.photo = convertView.findViewById(R.id.photo);
            holder.title = convertView.findViewById(R.id.title);
            holder.detail = convertView.findViewById(R.id.detail);

            // 将 ViewHolder 绑定到 convertView 以便复用
            convertView.setTag(holder);
        } else {
            // 如果 convertView 已存在，直接从 Tag 中获取 ViewHolder
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置列表项的背景颜色，奇数和偶数项使用不同的颜色
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.parseColor("#CAFFFF"));  // 偶数项颜色
        } else {
            convertView.setBackgroundColor(Color.parseColor("#B3FAFAFA"));  // 奇数项颜色
        }

        // 将数据绑定到 ViewHolder 中的控件
        holder.photo.setImageResource((Integer) listItems.get(position).get("photo"));  // 设置图片资源
        holder.title.setText((String) listItems.get(position).get("title"));  // 设置标题文本
        holder.detail.setText((String) listItems.get(position).get("detail"));  // 设置详情文本

        // 设置点击事件，当点击详情文本时，弹出包含详情信息的对话框
        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setIcon((Integer) listItems.get(selectId).get("photo"))  // 设置弹窗图标为该列表项图片
                        .setTitle((String) listItems.get(selectId).get("title"))  // 设置弹窗标题为该列表项标题
                        .setMessage((String) listItems.get(selectId).get("detail"))  // 设置弹窗内容为该列表项详情
                        .setPositiveButton("确定", null)  // 设置弹窗确认按钮
                        .create()
                        .show();  // 显示对话框
            }
        });

        // 返回处理后的列表项视图
        return convertView;
    }
}
