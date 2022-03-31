package com.developerx.ets.Helpers;

import android.Manifest;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionManager {

    private final Context context;

    public PermissionManager(Context context) {
        this.context = context;
    }
    public boolean verifyPermissions() {
        return  isDrawOverPermissionsGranted() & isUsageAccessGranted() && isCameraPermissionGranted();
    }

    public boolean getPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!isDrawOverPermissionsGranted()) {
                requestDrawOverPermissions();
            }
            if (!isUsageAccessGranted()) {
                requestUsageAccess();
            }if (!isCameraPermissionGranted()) {
                getCameraPermission(null, 0);
            }
        }
        return verifyPermissions();
    }

    private void requestUsageAccess() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    private void requestDrawOverPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }


    public boolean isUsageAccessGranted() {
        AppOpsManager appOps = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
        int mode = appOps.checkOpNoThrow(
                "android:get_usage_stats",
                android.os.Process.myUid(),
                context.getPackageName()
        );
        return mode == AppOpsManager.MODE_ALLOWED;
    }

    public boolean isDrawOverPermissionsGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            return Settings.canDrawOverlays(context);
        return true;
    }



    public boolean isCameraPermissionGranted() {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    public void getCameraPermission(Activity activity, int code){
        ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.CAMERA}, code);
    }

    public void getUsageAccessPermissions() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
