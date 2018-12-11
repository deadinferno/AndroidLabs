package com.dead.lab02u;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Element extends View{

    int atomicNumber;
    String shortName;
    String fullName;

    public Element(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Element);
        atomicNumber = typedArray.getInt(R.styleable.Element_e_atomic_number, 0);
        shortName = typedArray.getString(R.styleable.Element_e_short_name);
        fullName = typedArray.getString(R.styleable.Element_e_full_name);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();

        Paint paint = new Paint();
//        paint.setColor(Color.DKGRAY);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawPaint(paint);

        paint.setColor(Color.WHITE);

        paint.setTextSize(30);
        canvas.drawText(Integer.toString(atomicNumber), 10, 40, paint);

        paint.setTextSize(60);
        canvas.drawText(shortName, 60, 100, paint);

        paint.setTextSize(30);
        canvas.drawText(fullName, 30, 150, paint);

        super.onDraw(canvas);
        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = 50;
        int desiredHeight = 50;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }
}
