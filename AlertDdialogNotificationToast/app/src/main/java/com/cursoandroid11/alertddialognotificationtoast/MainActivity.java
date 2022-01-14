package com.cursoandroid11.alertddialognotificationtoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Cuadro de dialogo
        AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).create();//objeto AlertDialog con la creacion de la clase
        alertDialog.setTitle("Alert Title");//titulo del dialogo
        alertDialog.setMessage("This is a sample alert dialog message");//mensage del dialogo
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok", new DialogInterface.OnClickListener() {//se dispara
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();//mostrar
        */
        /*Codigo de ventana de carga de algo
        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("progress dialog messege here");
        progressDialog.setCanceledOnTouchOutside(false);//carga por siempre hasta que se apriete algo
        progressDialog.show();
        */

        //Toaste message

       // Toast.makeText(MainActivity.this,"This is a sample toast message",Toast.LENGTH_LONG).show;

        /* Lo que hace es crear un archivo xml donde declara botones y eso y genera asi un cuadro de dialogo
            llamado inFlater y ese flater lo mete en el dialogLayout
        LayoutInflater inFlater=getLayoutInflater();
        View dialogLayout= inFlater.inflate(R.layout.custom_alert_box,null);

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setView(dialogLayout);
        builder.show();

        Button btnCustom=dialogLayout.findViewById(R.id.custom_btn);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You click on th button", Toast.LENGTH_SHORT).show();
            }
        });
        */

        TimePicker timePicker=findViewById(R.id.time_picker);
        int hour=timePicker.getCurrentHour();
        int minute=timePicker.getCurrentMinute();
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this,hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();

            }
        });
        Toast.makeText(this,hour+":"+minute, Toast.LENGTH_SHORT).show();


    }
}