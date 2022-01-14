package com.cursoandroid11.torch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnTorch;
    boolean isTorchOn=false;
    CameraManager cameraManeger;//VARIABLE QUE ADMINISTRA LA CAMRA
    String cameraId;//ID DE LA CAMARA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esta variable es un booleano por el hehco de decir aplicationContext llamo un paquete de mensajes al sistema para que me diga el estado de la camara
        boolean isTorchAvailable=getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        btnTorch=findViewById(R.id.btn_torch);

        if(!isTorchAvailable){
            btnTorch.setEnabled(false);
            btnTorch.setText("Torch es not available");
        }

        try {
            //Uso la llamada context para el servicio de la camara
            cameraManeger=(CameraManager) getSystemService(Context.CAMERA_SERVICE);//Pide servicio a la camara
            //Debe devlver una lista y el primer parametro en la luz
            cameraId=cameraManeger.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


        btnTorch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isTorchOn){
                    //turn off the torch here
                    isTorchOn=false;
                    btnTorch.setText("Turn on Torch");
                } else{
                    //turn on the torch here
                    isTorchOn=true;
                    btnTorch.setText("Turn off torch");
                }
                switchTorch(isTorchOn);
            }
        });
    }

    //Metodo donde swichea el administrador de la camara para pasar el estado de ella
    public void switchTorch(boolean status){
        try {
            cameraManeger.setTorchMode(cameraId,status);
        }catch (Exception e){}
    }
}