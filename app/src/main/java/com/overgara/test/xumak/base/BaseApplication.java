package com.overgara.test.xumak.base;

import android.app.Activity;
import android.app.Application;

import com.overgara.test.xumak.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class BaseApplication extends Application implements HasActivityInjector {

    @Inject
    protected DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
