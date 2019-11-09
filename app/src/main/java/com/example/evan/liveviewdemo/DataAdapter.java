package com.example.evan.liveviewdemo;

import android.content.Context;
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
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(null==convertView){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.list_items,parent,false);
            holder=new ViewHolder();
            holder.mTitlem=(TextView)convertView.findViewById(R.id.ItemTitle);
            holder.mContent=(TextView)convertView.findViewById(R.id.ItemText);
            holder.mIcon=(ImageView)convertView.findViewById(R.id.ItemImage);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder)convertView.getTag();
        }
//        convertView= LayoutInflater.from(mContext).inflate(R.layout.list_items,parent,false);
//        ImageView imageView=(ImageView)convertView.findViewById(R.id.ItemImage);
//        TextView tvTitle=(TextView)convertView.findViewById(R.id.ItemTitle);
//        TextView tvContent=(TextView)convertView.findViewById(R.id.ItemText);
        holder.mIcon.setBackgroundResource(mData.get(position).getdIcon());
        holder.mTitlem.setText(mData.get(position).getdTitle());
        holder.mContent.setText(mData.get(position).getdContent());
        return convertView;
    }
    private static class ViewHolder{
        public TextView mTitlem,mContent;
        public ImageView mIcon;
    }
}
