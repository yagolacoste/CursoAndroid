package com.cursoandroid11.keylisteners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.DateKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.MultiTapKeyListener;
import android.text.method.QwertyKeyListener;
import android.text.method.TextKeyListener;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //allows decimals points  and signs(-1,-2)
        edt1=findViewById(R.id.edit_1);
        DigitsKeyListener dkl1=DigitsKeyListener.getInstance(true,true);
        edt1.setKeyListener(dkl1);

        //listens only to positive signs
        edt2=findViewById(R.id.edit_2);
        DigitsKeyListener dkl2=DigitsKeyListener.getInstance();
        edt2.setKeyListener(dkl2);

        //date listener
        edt3=findViewById(R.id.edit_3);
        DateKeyListener dkl3=DateKeyListener.getInstance();
        edt3.setKeyListener(dkl3);

        //date listener
        edt4=findViewById(R.id.edit_4);
        MultiTapKeyListener dkl4= new MultiTapKeyListener(TextKeyListener.Capitalize.WORDS,true);
        edt4.setKeyListener(dkl4);

        //allows qwerty layout for typing
        edt5=findViewById(R.id.edit_5);
        QwertyKeyListener dkl5= new QwertyKeyListener(TextKeyListener.Capitalize.SENTENCES,true);
        edt5.setKeyListener(dkl5);

    }
}