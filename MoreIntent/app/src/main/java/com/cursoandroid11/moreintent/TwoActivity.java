package com.cursoandroid11.moreintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TwoActivity extends AppCompatActivity {

    TextView txtValues;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        txtValues=findViewById(R.id.txt_value);

        String myValue=getIntent().getExtras().getString("uniqueID");
        txtValues.setText(myValue);

    }
}
