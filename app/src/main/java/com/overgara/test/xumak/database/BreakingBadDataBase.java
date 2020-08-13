package com.overgara.test.xumak.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.overgara.test.xumak.screens.character.data.repository.db.CharacterDao;
import com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity;

import static com.overgara.test.xumak.config.Constants.DATABASE_VERSION;

/**
 * Created By oscar.vergara on 13/08/2020
 */
@Database(
        entities = {FavoriteEntity.class},
        version = DATABASE_VERSION,
        exportSchema = false)
@TypeConverters({DataConverterHelper.class})
public abstract class BreakingBadDataBase extends RoomDatabase {

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

    public abstract CharacterDao characterDao();
}