package com.example.brondoua.helloworld;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by brondoua on 03/11/2016.
 */

public class DrawCanvas extends View {
    private Paint paint=null;
    private Path path=null;
    public DrawCanvas(Context context) {
        super(context);
        reset();
        setOnTouchListener(new mTouch());
    }
    protected void reset(){
        path=new Path();
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }
    protected void onDraw(Canvas canvas){
        canvas.drawPath(path, paint);
            }
    private class mTouch implements View.OnTouchListener{
        public boolean onTouch(View v, MotionEvent event){
            float eventX=event.getX();
            float eventY=event.getY();
            switch(event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    //quand je pose mon doigt je dis au systeme vient te positionner ici ->
                    path.moveTo(eventX,eventY);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    //une fois que je l'ai positionné, je le line to
                    path.lineTo(eventX,eventY);
                    break;
                case MotionEvent.ACTION_UP:
                    //nothing to do
                    break;
                default:
                    return false;
            }
            invalidate(); //appel le onDraw, a quel moment ma vue doit être modifiée etle dessins s'effectue plus tard
            return true;

        }
    }

}
