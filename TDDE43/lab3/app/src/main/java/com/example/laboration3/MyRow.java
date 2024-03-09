package com.example.laboration3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyRow extends View {

    Context context;
   private Paint myPaint;
    String input;

    public MyRow(Context context, String input) {

        super(context);
        this.input = input;
        init();
        this.context=context;

    }


    protected void init(){
        Log.d("Input", "shalom");
 //       setWillNotDraw(false);
        myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //    myPaint.setColor(Color.WHITE);
        myPaint.setTextSize(40.0f);

    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("Input", "measure:" + input );
        setMeasuredDimension(400,80);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("Input", "skriver:" + input );
        super.onDraw(canvas);
        canvas.drawText(input,5, 30, myPaint);
        Log.d("Input", "skriver:" + input );

    }



}
