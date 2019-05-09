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


    private long syncStartTime = 0;



}