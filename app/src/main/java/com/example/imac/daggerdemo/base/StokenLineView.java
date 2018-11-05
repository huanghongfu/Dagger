package com.example.imac.daggerdemo.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author imac
 * @date 18/10/23
 */

public class StokenLineView extends View {


    private Paint mPaint;
    private int mWidth;
    private int mHeight;


    public StokenLineView(Context context) {
        this(context, null);
    }

    public StokenLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StokenLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(8);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWidth = getWidth();
        mHeight = getHeight();
        canvas.drawLine(0, 0, mWidth, mHeight, mPaint);
        canvas.drawLine(mWidth, 0, 0, mHeight, mPaint);
        super.onDraw(canvas);
    }
}
