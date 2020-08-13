package com.overgara.test.xumak.screens.character.presentation.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.overgara.test.xumak.presentation.viewmodel.state.StateLiveData;
import com.overgara.test.xumak.screens.character.domain.interactor.ICharacterInteractor;
import com.overgara.test.xumak.screens.character.presentation.CharacterContract;
import com.overgara.test.xumak.screens.character.presentation.model.Character;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class CharacterViewModel extends ViewModel implements CharacterContract.ViewModel {

    @Inject
    ICharacterInteractor mInteractor;

    private StateLiveData<List<Character>> characters = new StateLiveData<>();
    private StateLiveData<Character> selected = new StateLiveData<>();
    private int positionSelected;
    private boolean isFinished = false;

    @Override
    public void setSelected(Character character, int position) {
        positionSelected = position;
        selected.postSuccess(character);
    }

    @Override
    public void getCharacters(int limit, int offset) {
        if(!isFinished) {
            characters.postLoading();
            mInteractor.getCharacters(limit, offset)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<List<Character>>() {
                @Override
                public void onSubscribe(Disposable d) {
                }

                @Override
                public void onNext(List<Character> response) {
                    isFinished = response.size() == 0;
                    characters.postSuccess(filterResponse(response));
                }

                @Override
                public void onError(Throwable e) {
                    characters.postError(e);
                }

                @Override
                public void onComplete() {
                }
            });
        }
    }

    private List<Character> filterResponse(List<Character> response) {

        //Remove common characters
        if(characters.getValue().getData() != null) {
            List<Character> realResponse = new ArrayList<>(response);
            response.retainAll(characters.getValue().getData());
            realResponse.removeAll(response);
            response = realResponse;
        }

        if (characters.getValue().getData() != null) {
            response.addAll(0,characters.getValue().getData());
        }

        return response;
    }

    @Override
    public void setFavorite(int position) {
        positionSelected = position;
        Character favorite = characters.getValue().getData().get(position);
        favorite.setFavorite(!favorite.isFavorite());
        mInteractor.setFavorite(favorite)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Boolean>() {

            @Override
            public void onNext(Boolean aBoolean) {
                characters.getValue().getData().set(position,favorite);
                characters.postSuccess(characters.getValue().getData());
            }

            @Override
            public void onError(Throwable e) {
                characters.postError(e);
            }

            @Override
            public void onSubscribe(Disposable d) {}
            @Override
            public void onComplete() {}
        });
    }

    @Override
    public void setFavoriteSelected() {
        if(positionSelected>=0) {
            setFavorite(positionSelected);
            selected.postSuccess(characters.getValue().getData().get(positionSelected));
        }
    }

    @Override
    public void setInteractor(ICharacterInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public StateLiveData<Character> getSelectedObs() {
        return selected;
    }

    @Override
    public StateLiveData<List<Character>> getListObs() {
        return characters;
    }
}
