package com.CursoAndroid11.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables
    TextView txtTimer;
    TextView txtTimerElapsed;
    Button btnReset;

    private final long startTime=50*1000;
    private final long interval=1*1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //Estado on create de la activity en android
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTimer=(TextView) findViewById(R.id.txt_timer);              //metodo para buscar el id del textview en layout
        txtTimerElapsed=(TextView) findViewById(R.id.txt_timer_elapsed);
        btnReset=(Button) findViewById(R.id.btn_reset);

        //Objeto contadorDrecementdoTiempo clase que le agregas los segundos o minutos y el intervalo que queres y tiene un satart asique debe ser un thread
        CountDownTimer countDownTimer=new CountDownTimer(startTime,interval) {
            @Override
            public void onTick(long millsUnitlFinished) {
                txtTimer.setText("Time: "+millsUnitlFinished/interval);
                txtTimerElapsed.setText("Time elapsed: "+(startTime-millsUnitlFinished)/interval);
            }

            @Override
            public void onFinish() {
                txtTimer.setText("TIMER FINISHED");
            }
        };
        countDownTimer.start();
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });
    }
}