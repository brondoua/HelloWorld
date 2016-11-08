package com.example.brondoua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WelcomeBallActivity extends AppCompatActivity implements View.OnClickListener{
    //BallCanvas dv;
    Button btGotoGame;
    //TextView scoreme,scoreyou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_ball);
        btGotoGame=(Button)findViewById(R.id.button_jeux);
        btGotoGame.setOnClickListener(this);
        /*scoreme=(TextView) findViewById(R.id.scoreme);
        scoreyou=(TextView) findViewById(R.id.scoreyou);
        scoreme.setVisibility(View.INVISIBLE);
        scoreyou.setVisibility(View.INVISIBLE);*/

    }



    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, BallActivity.class);

        /*
        TextView display1=(TextView) findViewById(R.id.maxpointmetext);
        TextView display2=(TextView) findViewById(R.id.maxpointyoutext);
        TextView display3=(TextView) findViewById(R.id.velocityxtext);
        TextView display4=(TextView) findViewById(R.id.velocityytext);
        */
        EditText display5=(EditText) findViewById(R.id.maxpointme);
        EditText display6=(EditText) findViewById(R.id.maxpointcom);
        EditText display7=(EditText) findViewById(R.id.velocityx);
        EditText display8=(EditText) findViewById(R.id.velocityy);
        String maxpointme,maxpointcom,velocityx,velocityy;
        try{
            maxpointme=display5.getText().toString();
            maxpointcom=display6.getText().toString();
            velocityx=display7.getText().toString();
            velocityy=display8.getText().toString();

        } catch (NumberFormatException e) {
            return;
        }
        intent.putExtra("maxpointme",maxpointme);
        intent.putExtra("maxpointcom",maxpointcom);
        intent.putExtra("velocityx",velocityx);
        intent.putExtra("velocityy",velocityy);
        startActivity(intent);
        /*
        display1.setVisibility(View.INVISIBLE);
        display2.setVisibility(View.INVISIBLE);
        display3.setVisibility(View.INVISIBLE);
        display4.setVisibility(View.INVISIBLE);
        display5.setVisibility(View.GONE);
        display6.setVisibility(View.INVISIBLE);
        display7.setVisibility(View.INVISIBLE);
        display8.setVisibility(View.INVISIBLE);
        btGotoGame.setVisibility(View.INVISIBLE);
        scoreme.setVisibility(View.VISIBLE);
        scoreyou.setVisibility(View.VISIBLE);

        dv=new BallCanvas(this);
        RelativeLayout rl=(RelativeLayout) findViewById(R.id.rl);
        rl.addView(dv);
        //test=new BallCanvas(this);
        */
    }
}
