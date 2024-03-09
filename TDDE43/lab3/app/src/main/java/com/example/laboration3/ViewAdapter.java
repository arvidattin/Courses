package com.example.laboration3;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ViewAdapter extends ArrayAdapter<String> {

    List<String> inputs;
    Context context;

    public ViewAdapter(@NonNull Context context, List<String> res) {
        super(context, 0, res);
        Log.d("fittadapter", "ViewAdapter: "+ res);
        this.context = context;
        this.inputs = res;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("hehehehe", "getView: ");
        Log.d("Input", "hej" + position );
        return new MyRow(context, inputs.get(position));
    }
}
