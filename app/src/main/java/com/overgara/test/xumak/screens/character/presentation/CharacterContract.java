package com.overgara.test.xumak.screens.character.presentation;

import com.overgara.test.xumak.presentation.viewmodel.state.StateLiveData;
import com.overgara.test.xumak.screens.character.domain.interactor.ICharacterInteractor;
import com.overgara.test.xumak.screens.character.presentation.model.Character;

import java.util.List;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public interface CharacterContract {

    interface ViewModel {
        void getCharacters(int limit, int offset);
        void setSelected(Character character,int position);
        void setFavorite(int position);
        void setFavoriteSelected();
        StateLiveData<Character> getSelectedObs();
        StateLiveData<List<Character>> getListObs();
    }
}
