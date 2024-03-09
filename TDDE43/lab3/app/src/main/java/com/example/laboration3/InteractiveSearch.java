package com.example.laboration3;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class InteractiveSearch extends androidx.appcompat.widget.AppCompatEditText {

    Context context;
    private int inputRows;
    ViewAdapter ViewAdapter;
    int id = 0;
    ListPopupWindow lpw;
    List<String> output = new ArrayList<String>();
    final InteractiveSearch dis = this;


    public InteractiveSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.inputRows = 10;
        run();
    }

    public void run() {
        lpw = new ListPopupWindow(context);

        lpw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dis.setText(output.get(i));

            }
        });

        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    lpw.dismiss();
                }
                String input = dis.getText().toString();
                Log.d("herhjeej", "afterTextChanged:" + input);
                id++;
                lpw.setAnchorView(dis);

                String place = "https://andla.pythonanywhere.com/getnames/" + id + "/" + input;
                RequestQueue queue = Volley.newRequestQueue(context);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, place, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("=================", "onResponse herjehej: ");
                            Gson gson = new Gson();
                            Name name = gson.fromJson(response, Name.class);
                            output.clear();

                            for (int i = 0; i < inputRows; i++) {
                                output.add(name.result.get(i));
                            }
                        } catch (Exception e) {
                            e.printStackTrace(System.out);

                        }
                        if (output.size() != 0) {
                            ViewAdapter = new ViewAdapter(context, output);
                            Log.d("fukfuk", "onResponse1: " + output);
                            Log.d("================", "onResponse: " + ViewAdapter.toString());
                            lpw.setAdapter(ViewAdapter);
                            lpw.show();

                        } else {
                            lpw.dismiss();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err = error.toString();
                    }
                });
                queue.add(stringRequest);
            }
        });
    }


}


