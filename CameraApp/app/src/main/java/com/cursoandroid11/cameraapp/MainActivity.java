package com.cursoandroid11.cameraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    ImageButton btnTakeImage;
    final int CAMERA_REQUEST=7080;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.img_view);
        btnTakeImage = findViewById(R.id.btn_image);


        btnTakeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Va a pedir los permidos de camara en el manifest
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);//activa la camara con el intetn pero tngo que buscar sobre el numeor que hace
            }
        });
    }
        @Override
       protected void onActivityResult(int requestCode,int resultCode,Intent data){//metodo donde se guarda la imagen para volver a la activity anterior
           super.onActivityResult(requestCode,resultCode,data);//el perimero es la imagen,la imagen seleccionada por el usuario,el tercero el trabajo
            if(requestCode==CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
                Bitmap photo=(Bitmap)data.getExtras().get("data");//guarda la foto en un bitmap
                imgView.setImageBitmap(photo);
            }
        }
}