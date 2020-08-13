package com.overgara.test.xumak.screens.character.data.repository;

import com.overgara.test.xumak.screens.character.data.repository.db.CharacterDao;
import com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity;
import com.overgara.test.xumak.screens.character.data.repository.service.CharacterApi;
import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created By oscar.vergara on 13/08/2020
 */
public class CharacterDataSource implements CharacterRepository {

    private CharacterApi api;

    private CharacterDao dao;

    @Inject
    public CharacterDataSource(CharacterApi api, CharacterDao dao) {
        this.api = api;
        this.dao =  dao;
    }

    @Override
    public Observable<List<CharacterDTO>> getCharactersFromApi(int limit, int offset){
        return api.getCharacters(limit,offset);
    }

    @Override
    public List<FavoriteEntity> getCharactersFromDB(int limit, int offset){
        return dao.getByLimit(limit,offset);
    }

    @Override
    public int insert(FavoriteEntity character){
        return (int) dao.insert(character);
    }

    @Override
    public int delete(int id){
        return dao.delete(id);
    }
}
