package com.overgara.test.xumak.screens.character.data.repository.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity;

import java.util.List;

import io.reactivex.Observable;

import static com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity.TABLE_NAME;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Dao
public interface CharacterDao {

    @Query("SELECT * FROM "+TABLE_NAME + " ORDER BY uid LIMIT :limit OFFSET :offset ")
    List<FavoriteEntity> getByLimit(int limit, int offset);

    @Insert
    long insert(FavoriteEntity product);

    @Query("DELETE FROM "+TABLE_NAME+" WHERE char_id=:id")
    int delete(int id);

}
