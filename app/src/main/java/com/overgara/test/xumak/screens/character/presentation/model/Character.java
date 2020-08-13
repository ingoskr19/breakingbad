package com.overgara.test.xumak.screens.character.presentation.model;

import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class Character extends CharacterDTO {

    private boolean isFavorite;

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public Character setCharacter(CharacterDTO character) {
        return (Character) super.setCharacter(character);
    }
}
