package com.bwei.text.suanfademo;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HengShuPingActivity extends AppCompatActivity {

    private static final String TAG = "isRun";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heng_shu_ping);
        Log.d(TAG, "-------onCreate: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "--------onRestart: ");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "------onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "--------onResume: ");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "---------onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "--------onStop: ");
    }

    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "---------onDestroy: ");
    }

//    Activity各生命周期函数


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "---------onSave ");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "---------onRestore");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        Log.d(TAG, "-------onContentChanged: ");
    }

    // 需在AndroidManifest里注册Activity的configChanges属性
     @Override
     public void onConfigurationChanged(Configuration newConfig) {
         super.onConfigurationChanged(newConfig);
         Log.d(TAG, "onConfigurationChanged");
         if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
             Log.d(TAG, "当前屏幕切换成横屏显示");
         } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
             Log.d(TAG, "当前屏幕切换成竖屏显示");
         }
     }

}
