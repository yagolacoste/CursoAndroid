package com.cursoandroid11.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtBody;
    Button btnSend;
    EditText editInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBody=findViewById(R.id.txt_email_body);
        btnSend=findViewById(R.id.btn_send);
        editInput=findViewById(R.id.edt_input);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent=new Intent(Intent.ACTION_SEND);//Se crea un intent que va a ser el que envie el email
                emailIntent.setType("text/html");
               // emailIntent.putExtra(Intent.EXTRA_TITLE,"thisis random email");//Titulo dle mail en el intent
                emailIntent.putExtra(Intent.EXTRA_EMAIL,"yago.lacoste17@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"This is the email");//Subject del mail del intent
                emailIntent.putExtra(Intent.EXTRA_TEXT,editInput.getText().toString());
                startActivity(emailIntent);
            }
        });
    }
}