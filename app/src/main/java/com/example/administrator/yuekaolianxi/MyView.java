package com.example.administrator.yuekaolianxi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 用途：
 * 作者：xuBoTao
 * 时间：2017/5/1 19:20
 */

public class MyView extends View{

    private setOnclic setonclic;

    interface setOnclic{
        void onclic();
    }

    public void setOnClickListener(setOnclic setonclic){
        this.setonclic=setonclic;
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        //设置画笔颜色
        paint.setColor(Color.GREEN);
        canvas.drawColor(Color.GREEN);
        //BLUE
        paint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getHeight()/2,paint);
        //WHITE
        paint.setColor(Color.WHITE);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getHeight()/4,paint);
        //  写文本
        String text = "圆环";
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        //居中显示文本
        canvas.drawText(text, 0 - rect.left + (getWidth() - rect.width())/2, 0 - rect.top + (getHeight()- rect.height())/2, paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        float sqrt = (float) Math.sqrt((x - getWidth()/2) * (x - getWidth()/2) + (y - getHeight()/2) * (y - getHeight()/2));

        if(event.getAction()==1){
            if(sqrt>getHeight()/4){
                Toast.makeText(getContext(), "外院", Toast.LENGTH_SHORT).show();
            }else if (sqrt<getHeight()/4){
                Toast.makeText(getContext(), "内院", Toast.LENGTH_SHORT).show();
                setonclic.onclic();
            }
        }
        return true;
    }
}
