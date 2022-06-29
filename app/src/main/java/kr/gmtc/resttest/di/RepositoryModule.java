package kr.gmtc.resttest.di;

import androidx.lifecycle.SavedStateHandle;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.scopes.ViewModelScoped;
import kr.gmtc.resttest.data.RestRepository;


@Module
@InstallIn(ViewModelComponent.class)
public class RepositoryModule {

    @Provides
    @ViewModelScoped
    static RestRepository provideRepo() {
        return new RestRepository();
    }
}
