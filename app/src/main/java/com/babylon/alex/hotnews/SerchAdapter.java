package com.babylon.alex.hotnews;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SerchAdapter extends BaseAdapter {

    ArrayList<String> list;
    int mSelectedItem = 0;
    LayoutInflater inflater;
    Activity activity;

    public SerchAdapter(Activity activity,int mSelectedItem, ArrayList<String> list) {
        this.mSelectedItem = mSelectedItem;
        this.list = list;
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void setmSelectedItem(int mSelectedItem) {
        this.mSelectedItem = mSelectedItem;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.search_list_view_item,null);
        View searchView = view.findViewById(R.id.searchView);
        TextView text = view.findViewById(R.id.searchText);
        if (i == mSelectedItem) {
            searchView.setBackgroundColor(Color.RED);
        }else{
            searchView.setBackgroundColor(Color.TRANSPARENT);
        }
        text.setText(list.get(i).toString());
        return view;
    }
}
