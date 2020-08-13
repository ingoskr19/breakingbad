package com.overgara.test.xumak.screens.character.domain.interactor.mapper;

import android.os.Build;

import com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity;
import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;
import com.overgara.test.xumak.screens.character.presentation.model.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created By oscar.vergara on 13/08/2020
 */
public class ObjectMapper {

    public static List<Character> entityToCharacter(List<FavoriteEntity> list) {
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return list.stream().map(ObjectMapper::entityToCharacter).collect(Collectors.toList());
        } else {
            List<Character> newList = new ArrayList<>();
            for(FavoriteEntity entity : list)
                newList.add(entityToCharacter(entity));
            return newList;
        }
    };

    public static List<Character> dtoToCharacter(List<CharacterDTO> list) {
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return list.stream().map(ObjectMapper::dtoToCharacter).collect(Collectors.toList());
        } else {
            List<Character> newList = new ArrayList<>();
            for(CharacterDTO dto : list)
                newList.add(dtoToCharacter(dto));
            return newList;
        }
    };

    public static Character dtoToCharacter(CharacterDTO dto){
        return new Character().setCharacter(dto);
    }

    public static Character entityToCharacter(FavoriteEntity entity) {
        Character character = new Character();
        character.setFavorite(entity.isFavorite());
        character.setAppearance(entity.getAppearance());
        character.setCharId(entity.getCharId());
        character.setName(entity.getName());
        character.setBirthday(entity.getBirthday());
        character.setOccupation(entity.getOccupation());
        character.setImg(entity.getImg());
        character.setStatus(entity.getStatus());
        character.setNickname(entity.getNickname());
        character.setCategory(entity.getCategory());
        character.setPortrayed(entity.getPortrayed());
        character.setCategory(entity.getCategory());
        character.setBetterCallSaulAppearance(entity.getBetterCallSaulAppearance());
        return character;
    };

    public static FavoriteEntity characterToEntity(Character character) {
        FavoriteEntity entity = new FavoriteEntity();
        entity.setFavorite(character.isFavorite());
        entity.setAppearance(character.getAppearance());
        entity.setCharId(character.getCharId());
        entity.setName(character.getName());
        entity.setBirthday(character.getBirthday());
        entity.setOccupation(character.getOccupation());
        entity.setImg(character.getImg());
        entity.setStatus(character.getStatus());
        entity.setNickname(character.getNickname());
        entity.setCategory(character.getCategory());
        entity.setPortrayed(character.getPortrayed());
        entity.setCategory(character.getCategory());
        entity.setBetterCallSaulAppearance(character.getBetterCallSaulAppearance());
        return entity;
    };
}
