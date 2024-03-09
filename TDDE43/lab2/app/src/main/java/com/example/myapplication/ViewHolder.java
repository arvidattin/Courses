package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class ViewHolder extends RecyclerView.ViewHolder{
    private final TextView name;
    private  final RecyclerView children;
    public  ViewHolder(View v, HolderListener listener){
        super(v);
        children = v.findViewById(R.id.children);
        children.setLayoutManager(new LinearLayoutManager(v.getContext()));
        children.setAdapter(new CustomAdapter(new ArrayList<Node>()));
        name = v.findViewById(R.id.nameHolder);
        name.setOnClickListener(view1->{
            listener.clickedAt(getAdapterPosition());
        });
    }
    public TextView getName(){
        return name;
    }


    public  RecyclerView getChildrenView(){
        return  children;
    }
}
