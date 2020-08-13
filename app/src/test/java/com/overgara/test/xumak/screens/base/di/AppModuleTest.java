package com.overgara.test.xumak.screens.base.di;

import android.content.Context;

import com.overgara.test.xumak.database.BreakingBadDataBase;
import com.overgara.test.xumak.screens.base.BaseApplicationTest;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created By oscar.vergara on 16/08/2020
 */
@Module
@RunWith(RobolectricTestRunner.class)
public abstract class AppModuleTest {

    @Provides
    @Singleton
    public static BreakingBadDataBase provideDataBase() {
        return Mockito.mock(BreakingBadDataBase.class);
    }

    @Binds
    abstract Context context(BaseApplicationTest application);
}
