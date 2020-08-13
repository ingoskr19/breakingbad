package com.overgara.test.xumak.screens.base.di;

import android.app.Application;

import com.overgara.test.xumak.screens.base.BaseApplicationTest;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created By oscar.vergara on 16/08/2020
 */
@Singleton
@Component(modules = {ActivityModuleTest.class,FragmentModuleTest.class,
        AndroidSupportInjectionModule.class,
        AppModuleTest.class})
public interface AppComponentTest extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplicationTest app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponentTest build();
    }
}
