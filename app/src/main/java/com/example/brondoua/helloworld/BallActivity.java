package com.example.brondoua.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class BallActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String maxpointme=getIntent().getStringExtra("maxpointme");
        Log.i("TAG :",maxpointme);
        String maxpointcom=getIntent().getStringExtra("maxpointcom");
        Log.i("TAG :",maxpointcom);
        String velocityx=getIntent().getStringExtra("velocityx");
        Log.i("TAG :",velocityx);
        String velocityy=getIntent().getStringExtra("velocityy");
        Log.i("TAG :",velocityy);
        setContentView(new BallCanvas(this,maxpointme,maxpointcom,velocityx,velocityy));


    }
}
