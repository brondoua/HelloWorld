package com.example.brondoua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WelcomeBallActivity extends AppCompatActivity implements View.OnClickListener{
    BallCanvas dv;
    Button btGotoGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_ball);
        btGotoGame=(Button)findViewById(R.id.button_jeux);
        btGotoGame.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        /*TextView display1=(TextView) findViewById(R.id.textView7);
        TextView display2=(TextView) findViewById(R.id.text_result);
        TextView display3=(TextView) findViewById(R.id.text_result);
        TextView display4=(TextView) findViewById(R.id.text_result);
        display1.setVisibility(View.INVISIBLE);*/
        dv=new BallCanvas(this);
        RelativeLayout rl=(RelativeLayout) findViewById(R.id.rl);
        rl.addView(dv);
        //test=new BallCanvas(this);
    }
}
