package com.yao.feicui.jsondemo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16245 on 2016/05/25.
 */
public class JsonAdapter extends BaseAdapter{
    List<Person> mList;
    LayoutInflater mInflater;

    public JsonAdapter(Context context, List<Person> list) {
        mList = list;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(mList!=null){
            return mList.size();
        }
        return 0;
    }

    @Override
    public Person getItem(int position) {
        if(mList!=null){
            return mList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=mInflater.inflate(R.layout.main,null);
        }
        TextView name= (TextView) convertView.findViewById(R.id.tv_name);
        TextView age= (TextView) convertView.findViewById(R.id.tv_age);
        Person person=mList.get(position);
        name.setText(person.name);
        age.setText(String.valueOf(person.age));
        return convertView;
    }
}
