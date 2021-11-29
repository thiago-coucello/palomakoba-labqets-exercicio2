package com.example.barapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox cb_cerveja, cb_agua, cb_cigarro, cb_vodka, cb_cachaca, cb_whisky;
    Button bt_efetuarPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb_agua = findViewById(R.id.cb_agua);
        cb_cachaca = findViewById(R.id.cb_cachaca);
        cb_cerveja = findViewById(R.id.cb_cerveja);
        cb_cigarro = findViewById(R.id.cb_cigarro);
        cb_vodka = findViewById(R.id.cb_vodka);
        cb_whisky = findViewById(R.id.cb_whisky);
        bt_efetuarPagamento = findViewById(R.id.bt_efetuarPedido);

        bt_efetuarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pedido = "";
                if (cb_agua.isChecked()) {
                    pedido += "1 Água\n";
                }
                if (cb_cachaca.isChecked()) {
                    pedido += "1 Cachaça\n";
                }
                if (cb_cerveja.isChecked()) {
                    pedido += "1 Cerveja\n";
                }
                if (cb_cigarro.isChecked()) {
                    pedido += "1 Cigarro\n";
                }
                if (cb_vodka.isChecked()) {
                    pedido += "1 Vodka\n";
                }
                if (cb_whisky.isChecked()) {
                    pedido += "1 Whisky\n";
                }

                if (pedido.equals("")) {
                    Toast.makeText(MainActivity.this, "Pedido inválido", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SplashScreen.class);
                    intent.putExtra("pedido", pedido);
                    startActivity(intent);
                }
            }
        });

    }

}