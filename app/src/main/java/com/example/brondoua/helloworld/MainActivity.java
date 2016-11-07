package com.example.brondoua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btGotoInscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGotoInscription=(Button)findViewById(R.id.button_register);
        btGotoInscription.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, InscriptionActivity.class);
        startActivity(intent);
    }
}
