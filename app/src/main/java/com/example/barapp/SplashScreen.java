package com.example.barapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    Intent i;
    String pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        i = getIntent();
        pedido = i.getExtras().getString("pedido");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = new Intent(SplashScreen.this, ResumoPedido.class);
                i.putExtra("pedido", pedido);
                startActivity(i);
            }
        }, 4000);
    }
}