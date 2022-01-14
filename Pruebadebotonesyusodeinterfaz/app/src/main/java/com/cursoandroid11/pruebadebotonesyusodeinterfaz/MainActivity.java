package com.cursoandroid11.pruebadebotonesyusodeinterfaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoComplete=findViewById(R.id.autoComplete);
        String[] data={"iphone","ipad","mac","imac","apple Watch",};//Posibles ejemplos de autocompletar
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,data);
        autoComplete.setAdapter(adapter);//le manda el array para que sepa el autocompletado

        CheckBox chkTerms=findViewById(R.id.chk_terms);
        if(chkTerms.isChecked()){

        }else {

        }
        RadioButton rdbMale=findViewById(R.id.rdb_male);
        if(rdbMale.isChecked()){

        }else {

        }
        RadioButton rdbFaMale=findViewById(R.id.rdb_famale);
        if(rdbFaMale.isChecked()){

        }else {

        }
        RadioButton rdbOther=findViewById(R.id.rdb_other);
        if(rdbOther.isChecked()){

        }else {

        }

        RadioGroup rdbGroup=findViewById(R.id.rdb_group);
        int selectBtnId=rdbGroup.getCheckedRadioButtonId();
        RadioButton rdbSelectedBtn=findViewById(selectBtnId);


        RatingBar ratingBar=findViewById(R.id.rating_bar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int userRating=(int) rating;
                switch(userRating){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        });

        Button btnMove=findViewById(R.id.btn_Move);
                btnMove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);//deslizamiento de las activity como desaparecer,deslizar,etc
                        finish();
                    }
                });


    }
}