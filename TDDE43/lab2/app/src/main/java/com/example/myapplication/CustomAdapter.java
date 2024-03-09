package com.example.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter
        extends RecyclerView.Adapter<ViewHolder> implements  HolderListener{
    private ArrayList<Node> localData;
    NodeListener listener;

    public CustomAdapter(ArrayList<Node> dataSet)
    {
        this.localData= dataSet;
    }
    public void setData(ArrayList<Node> newData){
        this.localData = newData;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.node_row,parent,false);
        return new ViewHolder(v,this);

    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Node n = localData.get(position);
        String theName=n.getName();
        if(n.getChildren().size()>0 && n.isExpanded ){
            theName= "˅"+theName;
        }
        else  if(n.getChildren().size()>0 && !n.isExpanded)
            theName= "˄"+theName;
        holder.getName().setText(theName);
        if(n.isExpanded) {

            holder.getChildrenView().setVisibility(View.VISIBLE);
            ((CustomAdapter)  holder.getChildrenView().getAdapter()).setData(n.getChildren());
            ((CustomAdapter)  holder.getChildrenView().getAdapter()).listener = listener;
            if(n.getChildren().size()==0)
                holder.getName().setBackgroundColor(Color.DKGRAY);

        }
        else {
            holder.getName().setBackgroundColor(Color.WHITE);
        //    previousHolder.getName().setBackgroundColor(Color.WHITE);
            holder.getChildrenView().setVisibility(View.GONE);
        }
    }

    public void expand(int pos) {
        Node n = localData.get(pos);
        //n.isExpanded = !n.isExpanded;
        if(n.isExpanded)
            n.isExpanded = false;
        else {
            n.isExpanded = true;
        }


        notifyDataSetChanged();

    }

    public void expandonly(int pos) {
        Node n = localData.get(pos);
        //n.isExpanded = !n.isExpanded;
            n.isExpanded = true;
        notifyDataSetChanged();

    }

    public void collapseonly(int pos) {
        Node n = localData.get(pos);
        n.isExpanded = false;
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {

        return this.localData.size();
    }


    @Override
    public void clickedAt(int pos) {


        Node n = localData.get(pos);
        //n.isExpanded = !n.isExpanded;
        if(n.isExpanded)
            n.isExpanded = false;
        else {
            n.isExpanded = true;
            listener.nodeSelected(n);
        }
        notifyDataSetChanged();
    }


}
