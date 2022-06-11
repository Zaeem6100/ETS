package com.developerx.ets;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    private static final int RequestPermissionCode =7;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (!PermissionCheck()) {
//            requestPermission();
//        }
//        if(!Python.isStarted()){
//            Python.start(new AndroidPlatform(getApplicationContext()));
//        }
//        Python py = Python.getInstance();
//        PyObject pyFunc = py.getModule("faceverify");
//        String hello = pyFunc.callAttr("helloworld").toString();
////        textView = findViewById(R.id.textView);
////        textView.setText(hello);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RequestPermissionCode) {
            if (grantResults.length > 0) {
                boolean CameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean InternetPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                boolean ExternalStoragePermissionRead = grantResults[2] == PackageManager.PERMISSION_GRANTED;
                boolean ExternalStoragePermissionWrite = grantResults[3] == PackageManager.PERMISSION_GRANTED;

                if (CameraPermission && InternetPermission && ExternalStoragePermissionRead && ExternalStoragePermissionWrite) {
                    Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }

    public  Boolean PermissionCheck(){

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA);
        int SecondPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), INTERNET);
        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        int FourthPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(),WRITE_EXTERNAL_STORAGE);



        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED &&
                FourthPermissionResult == PackageManager.PERMISSION_GRANTED;
    }


    public  void  requestPermission(){

        ActivityCompat.requestPermissions(this, new String[]
                {
                        CAMERA,
                        INTERNET,
                        READ_EXTERNAL_STORAGE,
                        WRITE_EXTERNAL_STORAGE
                }, RequestPermissionCode);

    }
}