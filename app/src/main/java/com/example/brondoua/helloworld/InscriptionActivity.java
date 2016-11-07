package com.example.brondoua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InscriptionActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_inscription);
        buttonSubmit=(Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Result.class);
        TextView pwd=(TextView) findViewById(R.id.text_pwd);
        String val;
        try{
            val=pwd.getText().toString();
        } catch (NumberFormatException e) {
            return;
        }
        intent.putExtra("PWD",val);
        startActivity(intent);

    }
}
