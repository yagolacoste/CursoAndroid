package com.cursoandroid11.customfont;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtCustom=findViewById(R.id.txt_custom);
        txtCustom.setTypeface(ResourcesCompat.getFont(MainActivity.this,R.font.lobster));
    }
}