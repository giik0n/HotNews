package com.babylon.alex.hotnews;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchDialog extends Dialog {
    private  Activity activity;
    public int mSelectedItem;
    ListView listView;
    SerchAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        listView = findViewById(R.id.searchListView);
        adapter = new SerchAdapter(activity,mSelectedItem,new ArrayList<String>(Arrays.asList("Top stories", "My news","Popular","Video")));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setmSelectedItem(i);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setAdapter(adapter);
        ImageView dismissButton = findViewById(R.id.dismissButtom);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

    public SearchDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }
}
