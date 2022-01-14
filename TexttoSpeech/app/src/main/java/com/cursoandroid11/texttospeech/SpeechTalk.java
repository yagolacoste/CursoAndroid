package com.cursoandroid11.texttospeech;
/*
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private final int REQUEST_CODE=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSpeakOperator=findViewById(R.id.btn_text_to_speech);
        btnSpeakOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkIntent=new Intent();
                checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivityForResult(checkIntent,1);
            }
        });

        Button btnSpeak = findViewById(R.id.btn_speak);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"sPEECHTEXT");
                    startActivityForResult(intent,REQUEST_CODE);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "Your device is not Supported", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==1){
            if(resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
                tts=new TextToSpeech(this,this);
                tts.setLanguage(Locale.US);
            }else{
                Intent installTtsIntent=new Intent();
                installTtsIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTtsIntent);
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            tts.speak("Hello",TextToSpeech.QUEUE_FLUSH,null);
        }
        else if(status== TextToSpeech.ERROR){
            Toast.makeText(this, "TTS is not propely executed", Toast.LENGTH_SHORT).show();
            tts.shutdown();
        }
    }*/
