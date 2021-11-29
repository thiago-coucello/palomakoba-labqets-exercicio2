package com.example.barapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoPedido extends AppCompatActivity {

    TextView tv_resumo;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido);

        i = getIntent();


        tv_resumo = findViewById(R.id.tv_resumoPedido);
        tv_resumo.setText(i.getExtras().getString("pedido"));
    }
}