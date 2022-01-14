  package com.cursoandroid11.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

  public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database=openOrCreateDatabase("testdb",MODE_PRIVATE,null);/// creo o armo una base de datos llamada testdb

        database.execSQL("CREATE TABLE users(username VARCHAR,password VARCHAR);");//creo una tabla donde le coloco los atributos de la tabla de base de datos
        database.execSQL("INSERT INTO users VALUES ('bin','1234');");//insrto valor

        Cursor result=database.rawQuery("SELECT * FROM users",null);
        result.moveToFirst();

        TextView textView=findViewById(R.id.txt_main);
        String userName=result.getString(0);
        String passwaord=result.getString(1);
        textView.setText(userName + passwaord);
    }
}