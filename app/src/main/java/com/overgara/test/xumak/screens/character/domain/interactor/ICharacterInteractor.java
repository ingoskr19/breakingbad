package com.overgara.test.xumak.screens.character.domain.interactor;

import com.overgara.test.xumak.screens.character.presentation.model.Character;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public interface ICharacterInteractor {
    Observable<List<Character>> getCharacters(int limit, int offset);
    Observable<Boolean> setFavorite(Character character);
}
