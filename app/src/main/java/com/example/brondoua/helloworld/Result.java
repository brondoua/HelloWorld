package com.example.brondoua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity implements View.OnClickListener {
    Button button_draw;
    Button button_ball;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String pwd=getIntent().getStringExtra("PWD");
        Log.i("TAG :",pwd);
        TextView display=(TextView) findViewById(R.id.text_result);
        if(pwd.equals("pwd")==true){
            display.setText("Connected!");
        }
        else {
            display.setText("Not allowed to connect, you can't access the app");
        }
        button_draw=(Button)findViewById(R.id.button_draw);
        button_draw.setOnClickListener(this);
        button_ball=(Button)findViewById(R.id.button_ball);
        button_ball.setOnClickListener(this);
        //
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch(view.getId()){
            case R.id.button_draw:
                intent = new Intent(this, DrawActivity.class);
                break;
            case R.id.button_ball:
                intent = new Intent(this, WelcomeBallActivity.class);
                break;
            default:
                intent = new Intent(this, DrawActivity.class);
        }

        startActivity(intent);
    }
}
