package com.overgara.test.xumak.screens.base;

import com.overgara.test.xumak.base.BaseApplication;
import com.overgara.test.xumak.screens.base.di.DaggerAppComponentTest;

/**
 * Created By oscar.vergara on 16/08/2020
 */
public class BaseApplicationTest extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponentTest.builder()
                .application(this)
                .build()
                .inject(this);
    }

}