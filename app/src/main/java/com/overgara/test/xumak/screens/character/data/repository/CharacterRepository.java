package com.overgara.test.xumak.screens.character.data.repository;

import com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity;
import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;

import java.util.List;

import io.reactivex.Observable;

public interface CharacterRepository {

    Observable<List<CharacterDTO>> getCharactersFromApi(int limit, int offset);

    List<FavoriteEntity> getCharactersFromDB(int limit, int offset);

    int insert(FavoriteEntity character);

    int delete(int id);

}
