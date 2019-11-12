package com.example.evan.liveviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Data> mData=null;
    private DataAdapter mAdapter=null;
    private Context mContext;


    private void initView(){
        mContext=MainActivity.this;
        listView=(ListView) findViewById(R.id.ListView);
        mData=new LinkedList<Data>();
        initData(mData);    //加载数据
        mAdapter=new DataAdapter((LinkedList<Data>)mData,mContext);
        listView.setAdapter(mAdapter);
    }

    private void initData(List<Data> mData) {
        for (int i=0;i<20;i++){
            mData.add(new Data("Title "+i,"Content "+i,R.drawable.xhr));
        }
        mData.add(new Data("Title20","fail",R.drawable.xhr));
        mData.add(new Data("Title21","pass",R.drawable.xhr));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ListView listView=(ListView)findViewById(R.id.ListView);
//
//        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
//        for (int i = 0; i < 16; i++) {
//            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("ItemImage", R.drawable.xhr);// 图像资源的ID
//            map.put("ItemTitle", "Level " + i);
//            map.put("ItemText", "Custom content! Custom content! ");
//            listItem.add(map);
//        }
//        // 生成适配器的Item和动态数组对应的元素
//        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,// 数据源
//                R.layout.list_items,// ListItem的XML实现
//                // 动态数组与ImageItem对应的子项
//                new String[] { "ItemImage", "ItemTitle", "ItemText" },
//                // ImageItem的XML文件里面的一个ImageView,两个TextView ID
//                new int[] { R.id.ItemImage, R.id.ItemTitle, R.id.ItemText });
//        // 添加并且显示
//        listView.setAdapter(listItemAdapter);
        initView();

        // 添加点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                setTitle("点击第" + arg2 + "项");
            }
        });
        // 添加长按点击
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v,
                                            ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("长按菜单-ContextMenu");
                menu.add(0, 0, 0, "弹出长按菜单0");
                menu.add(0, 1, 0, "弹出长按菜单1");
            }
        });
    }
    // 长按菜单响应函数
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        setTitle("点击了长按菜单的第" + item.getItemId() + "项");
        return super.onContextItemSelected(item);
    }
}
