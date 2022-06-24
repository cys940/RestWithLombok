package kr.gmtc.resttest;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;
import kr.gmtc.resttest.di.ApiModule;

@HiltAndroidApp
public class AppCore extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
