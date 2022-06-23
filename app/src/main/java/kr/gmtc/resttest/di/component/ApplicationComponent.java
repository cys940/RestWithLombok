package kr.gmtc.resttest.di.component;



import javax.inject.Singleton;

import dagger.Component;
import kr.gmtc.resttest.di.module.ApiModule;
import kr.gmtc.resttest.di.module.AppModule;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApplicationComponent{
    ApiComponent.Factory mainComponent();
}