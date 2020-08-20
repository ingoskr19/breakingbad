package com.overgara.test.xumak.di;

import android.app.Application;

import androidx.room.Room;

import com.overgara.test.xumak.database.BreakingBadDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

import static com.overgara.test.xumak.config.Constants.DATABASE_NAME;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
@InstallIn(ApplicationComponent.class)
public abstract class AppModule {

    @Provides
    @Singleton
    public static BreakingBadDataBase provideDataBase(Application context) {
        return Room.databaseBuilder(context,
                BreakingBadDataBase.class, DATABASE_NAME).build();
    }
}
