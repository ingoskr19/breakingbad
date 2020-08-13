package com.overgara.test.xumak.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.overgara.test.xumak.database.BreakingBadDataBase;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import static com.overgara.test.xumak.config.Constants.DATABASE_NAME;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
public abstract class AppModule {

    @Provides
    @Singleton
    public static BreakingBadDataBase provideDataBase(Application context) {
        return Room.databaseBuilder(context,
                BreakingBadDataBase.class, DATABASE_NAME).build();
    }

    @Binds
    abstract Context context(Application application);
}
