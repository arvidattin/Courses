package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // VERTICAL LINEAR
        LinearLayout verlay = new LinearLayout(this);
        verlay.setOrientation(LinearLayout.VERTICAL);

        // HORIZONTAL 1
           LinearLayout horlay1 = new LinearLayout(this);
           horlay1.setOrientation(LinearLayout.HORIZONTAL);
           TextView text1 = new TextView(this);
           text1.setText("Namn:");
           EditText edit1 = new EditText(this);
           edit1.setText("Martin");

           edit1.setX(115);
           horlay1.addView(text1);
           horlay1.addView(edit1);


        // HORIZONTAL 2
            LinearLayout horlay2 = new LinearLayout(this);
            horlay2.setOrientation(LinearLayout.HORIZONTAL);
            TextView text2 = new TextView(this);
            text2.setText("Lösenord:");

            EditText edit2 = new EditText(this);
            edit2.setText("hhhhhhhhhhhhhhh");
            edit2.setTransformationMethod(new PasswordTransformationMethod());

            edit2.setX(60);
            horlay2.addView(text2);
            horlay2.addView(edit2);

        // HORIZONTAL 3
             LinearLayout horlay3 = new LinearLayout(this);
             horlay3.setOrientation(LinearLayout.HORIZONTAL);
             TextView text3 = new TextView(this);
             text3.setText("Epost:");

             EditText edit3 = new EditText(this);
             edit3.setText("martin.martinsson@martin.se");

             edit3.setX(115);
             horlay3.addView(text3);
             horlay3.addView(edit3);

        // HORIZONTAL 4
            LinearLayout horlay4 = new LinearLayout(this);
            horlay4.setOrientation(LinearLayout.HORIZONTAL);
            TextView text4 = new TextView(this);
            text4.setText("Ålder:");

            SeekBar edit4 = new SeekBar(this);
            edit4.setMinWidth(400);

            edit4.setX(115);
            horlay4.addView(text4);
            horlay4.addView(edit4);



        verlay.addView(horlay1);
        verlay.addView(horlay2);
        verlay.addView(horlay3);
        verlay.addView(horlay4);

        setContentView(verlay);
    }
}