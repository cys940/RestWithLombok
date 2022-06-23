package kr.gmtc.resttest.di.component;

import dagger.Subcomponent;
import kr.gmtc.resttest.MainActivity;
import kr.gmtc.resttest.di.ActivityScope;

@ActivityScope
@Subcomponent
public interface ApiComponent {
    @Subcomponent.Factory
    interface Factory {
        ApiComponent create();
    }

    void inject(MainActivity mainActivity);
}
