package com.overgara.test.xumak.di;

import android.app.Application;

import com.overgara.test.xumak.base.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,ActivityModule.class,FragmentModule.class,
        AppModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication app);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
