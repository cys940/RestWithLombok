package kr.gmtc.resttest;

import android.app.Application;
import kr.gmtc.resttest.di.component.ApplicationComponent;
import kr.gmtc.resttest.di.component.DaggerApplicationComponent;
import kr.gmtc.resttest.di.module.ApiModule;
import kr.gmtc.resttest.di.module.AppModule;

public class AppCore extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("http://192.168.12.211:8083", 2,3,3,true,"gmt", "gmtvision"))
                .build();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
