package com.cursoandroid11.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDecimal,btnActionDivide,btnActionMultiply,btnActionSubtract,btnActionAdd,btnActionEnter,btnActionCut;
    TextView txtDisplayText;

    int firsNumbre,secondNumber;
    String ActionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn5=findViewById(R.id.btn_5);
        btn6=findViewById(R.id.btn_6);
        btn7=findViewById(R.id.btn_7);
        btn8=findViewById(R.id.btn_8);
        btn9=findViewById(R.id.btn_9);
        btn0=findViewById(R.id.btn_0);
        btnDecimal=findViewById(R.id.btn_dot);
        btnActionDivide=findViewById(R.id.btn_divide);
        btnActionMultiply=findViewById(R.id.btn_multiply);
        btnActionSubtract=findViewById(R.id.btn_subtract);
        btnActionAdd=findViewById(R.id.btn_addition);
        btnActionEnter=findViewById(R.id.btn_enter);
        txtDisplayText=findViewById(R.id.txt_out);
        btnActionCut=findViewById(R.id.btn_cut);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"0");
            }
        });
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+".");
            }
        });
        btnActionDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"/");
            }
        });
        btnActionMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"X");
            }
        });
        btnActionSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"-");
            }
        });
        btnActionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText(txtDisplayText.getText().toString()+"+");
            }
        });
        btnActionEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number=txtDisplayText.getText().toString();
                if(number.contains("/")){
                    String[] splitNumber=number.split("/");
                    double firstNumber=Double.parseDouble(splitNumber[0]);
                    double secondNumber=Double.parseDouble(splitNumber[1]);
                    txtDisplayText.setText(String.valueOf(div(firstNumber,secondNumber)));
                }else if(number.contains("X")){
                    String[] splitNumber=number.split("X");
                    double firstNumber=Double.parseDouble(splitNumber[0]);
                    double secondNumber=Double.parseDouble(splitNumber[1]);
                    txtDisplayText.setText(String.valueOf(mul(firstNumber,secondNumber)));
                }else if(number.contains("-")){
                    String[] splitNumber=number.split("-");
                    double firstNumber=Double.parseDouble(splitNumber[0]);
                    double secondNumber=Double.parseDouble(splitNumber[1]);
                    txtDisplayText.setText(String.valueOf(sub(firstNumber,secondNumber)));
                }else if(number.contains("+")){
                    String[] splitNumber=number.split("\\+");
                    double firstNumber=Double.parseDouble(splitNumber[0]);
                    double secondNumber=Double.parseDouble(splitNumber[1]);
                    txtDisplayText.setText(String.valueOf(add(firstNumber,secondNumber)));
                }

            }
        });
        btnActionCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDisplayText.setText("");
            }
        });

    }

    public double add(double a,double b){
        return a+b;
    }
    public double sub(double a,double b){
        return a-b;
    }
    public double div(double a,double b){
        return a/b;
    }
    public double mul(double a,double b){
        return a*b;
    }
}