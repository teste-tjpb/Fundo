package com.szkct.weloopbtsmartdevice.main;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kct.fundo.btnotification.R;
import com.mediatek.wearable.WearableManager;
import com.szkct.weloopbtsmartdevice.net.HttpToService;
import com.szkct.weloopbtsmartdevice.net.NetWorkUtils;
import com.szkct.weloopbtsmartdevice.util.ActionBarSystemBarTint;
import com.szkct.weloopbtsmartdevice.util.Constants;
import com.szkct.weloopbtsmartdevice.util.DailogUtils;
import com.szkct.weloopbtsmartdevice.util.SharedPreUtil;
import com.szkct.weloopbtsmartdevice.util.Utils;
import com.szkct.weloopbtsmartdevice.view.CustomProgress;
import android.app.Dialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * 
 * @author chendalin
 * 说明：ActionBarActivit对于最新的sdk 20x版本以上已经被官方抛弃，不建议使用，先推荐使用AppCompatActivity
 */
public class AboutActivity extends AppCompatActivity  {

    private static final String TAG = "AboutActivity";
    private TextView version_name;
    private TextView version_tv;
    
    private TextView privacy_tv;
    private TextView mWatch_mall;
    private TextView watch_fota_tvs;
    private ImageView aboutlogo_iv;
    
    private LinearLayout mLinearAbout;
 //   private Toolbar toolbar;
    public static boolean isLatestVersion = true;
    private Context context;

    public Dialog dialog;

    private long syncStartTime = 0;

    public Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
            case 1:   // todo ---  有新版本
                try {

                    if(Utils.isActivityRunning(AboutActivity.this,AboutActivity.class.getName())){
                        if (null != dialog) {
                            if(dialog.isShowing()){
                                dialog.setCancelable(true);
                                dialog.dismiss();
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(Utils.isActivityRunning(AboutActivity.this,AboutActivity.class.getName())){
                    DailogUtils.doNewVersionUpdate(AboutActivity.this);
                }
                break;
            case 2:  // todo ---  没有有新版本
                if(Utils.isActivityRunning(AboutActivity.this,AboutActivity.class.getName())){
                    try {
                        if (null != dialog) {
                            if(dialog.isShowing()){
                                dialog.setCancelable(true);
                                dialog.dismiss();
                            }}
                    } catch (Exception e) {e.printStackTrace();}
                    if(!(AboutActivity.this).isFinishing()) {
                        DailogUtils.notNewVersionUpdate(AboutActivity.this);
                    }
                }
                break;

            case 6:
                if (null != dialog) {
                    if(dialog.isShowing()){
                        dialog.setCancelable(true);
                        dialog.dismiss();
                    }
                }
                Toast.makeText(AboutActivity.this, getString(R.string.checking_new_version_fail), Toast.LENGTH_SHORT).show();
                break;

            }
        }
        
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (syncStartTime > 30) {
                if (System.currentTimeMillis() - syncStartTime > 30 * 1000) {
                    Message msg = myHandler.obtainMessage(6);
                    myHandler.sendMessage(msg);
                    return ;
                }
                Toast.makeText(AboutActivity.this, getString(R.string.checking_new_version_fail), Toast.LENGTH_SHORT).show();
		    Toast.makeText(AboutActivity.this, getString(R.string.checking_new_version_fail), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(AboutActivity.this, getString(R.string.checking_new_version_fail), Toast.LENGTH_SHORT).show();
                return ;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != dialog){
            dialog.dismiss();
            dialog.setCancelable(true);
            dialog = null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    }
}