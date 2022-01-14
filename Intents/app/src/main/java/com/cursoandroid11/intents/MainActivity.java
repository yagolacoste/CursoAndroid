package com.cursoandroid11.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 //       String url ="https://yahoo.com";//url de la pagina yahoo
 //       Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));//llama a un intent donde accede directo a la pagina es para almacenar la info
 //       startActivity(intent);//Inicia el intetn


        Intent phoneIntetn=new Intent(Intent.ACTION_CALL,Uri.parse("tel:="))
    }
}