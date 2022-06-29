package kr.gmtc.resttest;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class AppCore extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
