package kr.gmtc.resttest.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import kr.gmtc.resttest.data.Impl.RestRepositoryImpl;
import kr.gmtc.resttest.viewmodel.RestViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    public RestRepositoryImpl repository;

    public ViewModelFactory(RestRepositoryImpl repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RestViewModel.class)) {
            return ((T)new RestViewModel(repository));
        }

        throw new IllegalStateException("not find");
    }
}
