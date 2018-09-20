package com.babylon.alex.hotnews.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.babylon.alex.hotnews.Item;
import com.babylon.alex.hotnews.NewsAdapter;
import com.babylon.alex.hotnews.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class MyNewsFragment extends Fragment {
    ArrayList<Item> list;
    GridView gridView;
    NewsAdapter adapter;

@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        list = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_my_news, container, false);
        gridView = view.findViewById(R.id.gridView);
        adapter = new NewsAdapter(getActivity(),list);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("news").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                list.clear();
                    for (DocumentSnapshot document : documentSnapshots) {
                        list.add(new Item(document.getString("content"),document.getString("image")));
                        adapter.notifyDataSetChanged();
                    }
                }
            });
        gridView.setAdapter(adapter);
        return view;
    }

}
