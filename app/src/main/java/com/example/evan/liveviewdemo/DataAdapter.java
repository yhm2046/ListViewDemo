package com.example.evan.liveviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by evan on 2019/11/9.
 */

public class DataAdapter extends BaseAdapter {
    private LinkedList<Data> mData;
    private Context mContext;
    public DataAdapter(LinkedList<Data> mData,Context mContext){
        this.mData=mData;
        this.mContext=mContext;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
//        View view;
        if(null==convertView){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.list_items,parent,false);

            holder.mTitlem=convertView.findViewById(R.id.ItemTitle);
            holder.mContent=convertView.findViewById(R.id.ItemText);
            holder.mIcon=convertView.findViewById(R.id.ItemImage);
            convertView.setTag(holder);
        }else {
//            view = convertView;
            holder=(ViewHolder)convertView.getTag();
        }
        String titletxt=mData.get(position).getdTitle();
        holder.mTitlem.setText(titletxt);
            if(null!=mData){    //根据内容不同设置标题颜色
                if(("fail").equals(mData.get(position).getdContent())){
                    holder.mTitlem.setTextColor(Color.RED);
                }else if(("pass").equals(mData.get(position).getdContent())){
                    holder.mTitlem.setTextColor(Color.GREEN);
                }else {
                    holder.mTitlem.setTextColor(Color.BLUE);
                }
            }
        holder.mIcon.setBackgroundResource(mData.get(position).getdIcon());
        holder.mContent.setText(mData.get(position).getdContent());
        return convertView;
    }
    private static class ViewHolder{
        public TextView mTitlem;
        public TextView mContent;
        public ImageView mIcon;
    }
}
