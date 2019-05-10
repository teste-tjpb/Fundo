package com.szkct.weloopbtsmartdevice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.szkct.weloopbtsmartdevice.main.WelcomeActivity;
import com.szkct.weloopbtsmartdevice.util.ScreenManager;
import com.szkct.weloopbtsmartdevice.util.SystemUtils;


/**1像素Activity
 *
 */

public class SinglePixelActivity extends AppCompatActivity {
    private static final String TAG = "KeepAppAlive";   // KeepAppAlive   SinglePixelActivity

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if(Contants.DEBUG)
            Log.d(TAG, "onCreate--->Start 1 pixel keep alive");
        Window mWindow = getWindow();
        mWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams attrParams = mWindow.getAttributes();
        attrParams.x = 0;
        attrParams.y = 0;
        attrParams.height = 300;
        attrParams.width = 300;
        mWindow.setAttributes(attrParams);
        // 绑定SinglePixelActivity到ScreenManager
        ScreenManager.getScreenManagerInstance(this).setSingleActivity(this);
    }

    @Override
    protected void onDestroy() {
//        if(Contants.DEBUG)
            Log.d(TAG,"onDestroy--->1像素保活被终止");
        if(! SystemUtils.isAPPALive(this, "com.kct.fundo.btnotification")){  // Contants.PACKAGE_NAME
            Intent intentAlive = new Intent(this, WelcomeActivity.class);   // 
            intentAlive.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentAlive);
            Log.i(TAG,"SinglePixelActivity---->APP被干掉了，我要重启它");
        }
        super.onDestroy();
    }
}
