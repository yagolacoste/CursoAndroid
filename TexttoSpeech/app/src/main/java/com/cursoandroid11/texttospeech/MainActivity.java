package com.cursoandroid11.texttospeech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private final int REQUEST_CODE=500;
    private TextToSpeech tts;
    TextView txtSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSpeak = findViewById(R.id.btn_speak);
        Button btnSpeak_to_text=findViewById(R.id.btn_text_to_speech);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Puedes hablar");//pone en el intent para que n la pestaña salga esa palbra
                    startActivityForResult(intent,REQUEST_CODE);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "Your device is not Supported", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
        btnSpeak_to_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkIntent=new Intent();
                checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivityForResult(checkIntent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            ArrayList<String> text=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            txtSpeech=findViewById(R.id.txt_main);
            txtSpeech.setText(text.get(0).toString());
        }
        super.onActivityResult(requestCode,resultCode,data);
    }


    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            String speeak = txtSpeech.getText().toString();
            tts.speak(speeak, TextToSpeech.QUEUE_FLUSH, null);
        } else if (status == TextToSpeech.ERROR) {
            Toast.makeText(this, "TTS is not propely executed", Toast.LENGTH_SHORT).show();
            tts.shutdown();
        }
    }
}