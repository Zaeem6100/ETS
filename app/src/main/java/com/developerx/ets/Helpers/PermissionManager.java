package com.developerx.ets.Helpers;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

public class PermissionManager {
    Context context;
    public PermissionManager(Context context1) {
        this.context = context1;
    }


//    Get camera permission and storage permission from user
    public boolean checkPermission() {
        int result = context.checkCallingOrSelfPermission(Manifest.permission.CAMERA);
        int result1 = context.checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;

    }



}



