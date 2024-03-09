package com.example.myapplication;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    // HashMap<Node, Node> datahash = new HashMap<Node,Node>();

    boolean parentComplete = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Node> data = tempData();
        RecyclerView rw = findViewById(R.id.rView);
        EditText locationText = (EditText) findViewById(R.id.indextext);
        CustomAdapter adapter = new CustomAdapter(data);
        Node previousParent;
        boolean notWriting = true;

        adapter.listener = node -> {

            Log.d("Input", "flög in här");

            if (node.parent != null) {

                locationText.setText("/" + node.parent.getName() + "/" + node.getName() + "/");

                adapter.notifyDataSetChanged();

            }

            if (node.parent == null) {

                locationText.setText("/" + node.getName() + "/");

            }

        };

        rw.setAdapter(adapter);
        rw.setLayoutManager(new LinearLayoutManager(this));


        locationText.setText("/");

        locationText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String[] input = locationText.getText().toString().split("/");

                if (input.length > 1) {

                    Boolean bole = true;
                    Boolean bole2 = true;

                    for (int x = 0; x < data.size(); x++) {
                        String parentName = data.get(x).name;
                        String lettersP = input[1];

                        if (input.length > 1) {

                        }

                        if (parentName.startsWith(lettersP)) {
                            bole = false;
                            locationText.setTextColor(Color.BLACK);

                            if (lettersP.equals(parentName)) {

                                adapter.expandonly(x);

                                closeOther(data.get(x), data);

                                if (input.length > 2) {

                                    for (int j = 0; j < data.get(x).getChildren().size(); j++) {


                                        ArrayList<Node> children = data.get(x).getChildren();
                                        Node child = children.get(j);
                                        String childName = child.name;

                                        String letters2 = input[2];

                                        if (childName.startsWith(letters2)) {
                                            bole2 = false;

                                            if (letters2.equals(childName)) {

                                                child.isExpanded = true;
                                                closeOther(child, child.parent.getChildren());
                                                closeOtherParent(child.parent, data);


                                            }

                                        }

                                    }

                                    if (bole2) {
                                        locationText.setTextColor(Color.RED);
                                    }

                                }
                            }
                        }


                    }

                    if (bole) {
                        locationText.setTextColor(Color.RED);

                    }


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }

    public void closeOther(Node node, ArrayList<Node> list) {

        for (Node n : list) {
            if (n.getName() != node.getName()) {
                n.isExpanded = false;

                for(Node b : node.getChildren()) {
                    b.isExpanded = false;
                }

            }

        }
    }

    public void closeOtherParent(Node node, ArrayList<Node> list) {

        for (Node n : list) {
            if (n != node ) {
                n.isExpanded = false;

            }

        }
    }


    protected boolean isEmpty(EditText editText) {
        return (editText.getText().toString().equals(""));
    }


    private ArrayList<Node> tempData() {
        //   HashMap<Node, Node> meals = new HashMap<Node, Node>();

        Node A = new Node("Starters");
        Node B = new Node("Starters");
        Node C = new Node("Dessert");


        String[] meals = {"Toast", "Soup", "Bread", "Sausage", "Schnitzel", "Fondue", "Tiramisu", "Strawberry", "Pancakes"};

        for (int x = 0; x < 9; x++) {

            if (x <= 2) {
                Node t = new Node(meals[x]);
                A.addChild(t);
                //   datahash.put(A,t);

            } else if (x <= 5) {
                Node t = new Node(meals[x]);
                B.addChild(t);
                //  datahash.put(B,t);
            } else if (x <= 8) {
                Node t = new Node(meals[x]);
                C.addChild(t);
                //  datahash.put(C,t);
            }
        }

        ArrayList<Node> data = new ArrayList<>();
        //HashMap<Node, Node> data = new HashMap<Node,Node>();
        data.add(A);
        data.add(B);
        data.add(C);


        return data;
    }

}