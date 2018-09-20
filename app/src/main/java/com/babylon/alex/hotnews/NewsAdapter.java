package com.babylon.alex.hotnews;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<Item> list;
    LayoutInflater inflater;

    public NewsAdapter(Activity activity, ArrayList<Item> list) {
        this.activity = activity;
        this.list = list;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_view,null);
        ImageView image = view.findViewById(R.id.imageView);
        ReadMoreTextView text = (ReadMoreTextView) view.findViewById(R.id.content);
        text.setText(list.get(i).getContent());
        String iconLink = list.get(i).getImage();
        Picasso.get().load(iconLink).into(image);
        return view;
    }
}
