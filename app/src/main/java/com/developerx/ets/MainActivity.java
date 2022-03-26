package com.developerx.ets;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int RequestPermissionCode =7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!PermissionCheck()) {
            requestPermission();
        }

        setContentView(R.layout.activity_main);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case RequestPermissionCode:
                if (grantResults.length > 0){
                    boolean CameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean InternetPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean ExternalStoragePermission = grantResults[2] == PackageManager.PERMISSION_GRANTED;

                    if(CameraPermission && InternetPermission && ExternalStoragePermission){
                        Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
        }
    }

    public  Boolean PermissionCheck(){

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET);
        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);



        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED;
    }


    public  void  requestPermission(){

        ActivityCompat.requestPermissions(this, new String[]
                {
                        CAMERA,
                        INTERNET,
                        WRITE_EXTERNAL_STORAGE,
                }, RequestPermissionCode);

    }
}