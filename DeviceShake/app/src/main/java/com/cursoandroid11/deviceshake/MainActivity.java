package com.cursoandroid11.deviceshake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private float aceleration,acelerationNow,acelerationLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Objects.requireNonNull(sensorManager).registerListener(sensorListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

        aceleration=10f;
        acelerationNow=SensorManager.GRAVITY_EARTH;
        acelerationLast=SensorManager.GRAVITY_EARTH;

    }

    private SensorEventListener sensorListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x=sensorEvent.values[0];
            float y=sensorEvent.values[1];
            float z=sensorEvent.values[2];

            acelerationLast=acelerationNow;
            acelerationNow=(float)Math.sqrt((double) (x*x+y*y+z*z));
            float delta=acelerationNow-acelerationLast;
            aceleration=aceleration*0.9f+delta;
            if(aceleration>12){
                Toast.makeText(MainActivity.this, "You are shaking the divice", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }


    };
    protected void onResume(){
        Objects.requireNonNull(sensorManager).registerListener(sensorListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        super.onResume();
    }

    protected void onPause(){
        sensorManager.unregisterListener(sensorListener);
        super.onPause();
    }
}
