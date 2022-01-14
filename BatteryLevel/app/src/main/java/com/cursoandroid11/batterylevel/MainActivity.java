package com.cursoandroid11.batterylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtBaterryLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBaterryLevel=findViewById(R.id.txt_battery_level);

        //Llo que hace es crear un broadcastReceiver que es un metodo que recibe un broadcast mensseger
        //que basicamente evalua cuando la bateria esta baja
        //toma el nivel de la bateria y ahi mostramos el mensje por consola .Con el baterry change es tomar los camios en la bateria
        //
        this.registerReceiver(this.myBaterryReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    BroadcastReceiver myBaterryReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int baterryLevel=intent.getIntExtra("Level",0);
            txtBaterryLevel.setText("Baterry Level"+ baterryLevel);
        }
    };
}