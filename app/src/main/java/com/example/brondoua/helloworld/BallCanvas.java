package com.example.brondoua.helloworld;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by brondoua on 03/11/2016.
 */

public class BallCanvas extends View {



    private int xballe,xraquette; // on ne definit pas les valeurs ici on les definit dans le constructeur
    private int yballe,yraquette;
    private long td=30;
    private int dxballe; // deplacement par rapport à x
    private int dyballe;
    private Context mc; //contex de l'application pour récuperer l'image
    private Handler h; // le handler permet de lancer des threads, des runnable avec un certain delai, il suffit donc de savoir ce qu'on met dans le thread
    private Runnable r;
    private GestureDetector mgd;
    private Path path=null;
    private int tailleraquetteX;
    private int tailleraquetteY;
    TextView tv ;





    public BallCanvas(Context context) {
        super(context);
        mc=context; // on en profite on initialiser mc
        xballe=yballe=0;
        dxballe=dyballe=10;
        xraquette=0;
        tailleraquetteX=tailleraquetteY=0;
        h=new Handler();
        r=new Runnable(){
            @Override
            public void run(){
                invalidate();
            }
        };
        mgd = new GestureDetector(mc,new mTouch1());




    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mgd.onTouchEvent(event);
    }


        protected void onDraw(Canvas canvas){
            // on recupere l'image de la balle

            
            BitmapDrawable raquette = (BitmapDrawable)mc.getResources().getDrawable(R.drawable.raquette,null);
            yraquette=getHeight()-raquette.getMinimumHeight();
            BitmapDrawable ball = (BitmapDrawable)mc.getResources().getDrawable(R.drawable.ball,null);// dans le getDrawable on donne l'identifiant & le theme, ici le theme nous interesse pas on met null
            if(xballe+ball.getMinimumWidth()>=getRight() || xballe<getLeft()) { //
                dxballe=-dxballe;
            }
            if(yballe+ball.getMinimumHeight()>=getBottom() || yballe<getTop() ){
                //|| x-ball.getMinimumHeight()<=0
                dyballe=-dyballe;
            }
            // j'ai fait le choix de faire une autre boucle if pour cette condition afin d'être sur que la balle ira vers le haut
            //sinon lorsque je rate la balle, qu'elle touche le sol et que je pointe dessus, les coordonnées de xballe+taille balle sont superieur à yraquette et il renvoie la balle vers le bas
            if((dyballe>0 && yballe+ball.getMinimumHeight()>yraquette&& (xballe>xraquette &&xballe<xraquette+raquette.getMinimumWidth() ) )){
                dyballe=-dyballe;
            }
            xballe+=dxballe; //=getWidth()/2;
            yballe+=dyballe; //getHeight()/2;
            canvas.drawBitmap(ball.getBitmap(),xballe,yballe,null);
            canvas.drawBitmap(raquette.getBitmap(),xraquette,yraquette,null);
            h.postDelayed(r,td); // au bout de 30 mili secondes il va lancer le run, relancer le invalidate, le invalidate va lancer le onDraw qui va ajouter d aux y & y et refaire le run & ainsi de siute;
            tailleraquetteX=raquette.getMinimumWidth();
            tailleraquetteY=raquette.getMinimumWidth();

        }
    private class mTouch1 implements GestureDetector.OnGestureListener{
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return true; // on a remplacer le false par un true afin que l'enchainement d'evement se passe bien car si on fait un onfling, un ondown se passe avant et s'il renvoie false le onfling ne va pas se passer
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent1, MotionEvent motionEvent2, float v, float v1) { // methode utilisée pour la palette du tennis, a première page qui definit les parametres
            //la vitesse etc et les points pour gagner, si il touche la bar je gagne un point si ça touche le sol l'autre gagne
            float eventX1=motionEvent1.getX();
            float eventY1=motionEvent1.getY();
            float eventX2=motionEvent2.getX();
            float eventY2=motionEvent2.getY();
            if(eventX2<xraquette+tailleraquetteX && eventX2>xraquette-tailleraquetteX && eventY2<yraquette+tailleraquetteY && eventY2>yraquette-tailleraquetteY ){

            xraquette=(int)eventX2;
            invalidate();
            }

            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
         /*   int tga=(int) Math.abs(e1.getY()-e2.getY()/e1.getX()-e2.getX());

            if(velocityX<0){ // si on veut adapter la vitesse, on fait le rapport entre les deux volocity et on augmente dx ici
                dx=-10;
            }
            else dx=10;
            if(velocityY<0){
                dy=-tga*10;
            }
            else dy=tga*10;
            //invalidate(); */
            return true;
        }
    }



}
