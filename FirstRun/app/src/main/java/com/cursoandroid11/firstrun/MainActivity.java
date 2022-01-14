package com.cursoandroid11.firstrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    Context context;
    TextView txthello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        prefs=context.getSharedPreferences("appPrefs",0);
        txthello=findViewById(R.id.txt_hello);
        if(getFirstRun()){
            setRunned();
            //se requiere el primer numero del telefono
            txthello.setText("hello First time User");
        }
        else{
            //este no es el primer numero de tu app de telefono
            txthello.setText("You are not a first Time user");
        }
    }
    //Hizo dos metodos
    boolean getFirstRun(){
        return prefs.getBoolean("firstRun",true);
    }

    void setRunned(){
        SharedPreferences.Editor edit=prefs.edit();
        edit.putBoolean("firstRun",false);
        edit.commit();
    }
}