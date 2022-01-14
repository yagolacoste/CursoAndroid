package com.CursoAndroid11.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //crea un metodo handle para pasar de una actividad a otra
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Se crea una relacion entre splash y main activity
                Intent intent =new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();//Lo hace terminar porque sino se mantiene esta actividad y esta mal deberia finalizar
            }
        },1200);
    }
}
