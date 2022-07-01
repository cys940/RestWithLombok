package kr.gmtc.resttest.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import kr.gmtc.resttest.data.Impl.RestRepositoryImpl;


@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Singleton
    @Provides
    static RestRepositoryImpl provideRepo() {
        return new RestRepositoryImpl();
    }
}
