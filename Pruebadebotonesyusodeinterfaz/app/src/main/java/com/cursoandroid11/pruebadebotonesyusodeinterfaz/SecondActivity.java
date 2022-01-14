package com.cursoandroid11.pruebadebotonesyusodeinterfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Button btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);//si apretas el back del ceu la hace salir
                startActivity(intent);
                finish();//la hace terminar porque sino la ram se guarda el historial de acceso entoncces se mueve entre actividades y hace termianr la anterior
            }
        });

        ImageView imgView=findViewById(R.id.img_view);
        //Tenemos que crear la animacion de la imagen entonces en res crear un recurso y ponerle animacion y crear un resourse de animacion
        //Eb shake_animation hay que poner los parametros de moviemiento

        Animation shakeAnimation= AnimationUtils.loadAnimation(SecondActivity.this,R.anim.shake_animation);
        imgView.startAnimation(shakeAnimation);
    }
}