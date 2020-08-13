package com.overgara.test.xumak.screens.character.domain.interactor;

import com.overgara.test.xumak.screens.character.data.repository.CharacterRepository;
import com.overgara.test.xumak.screens.character.data.repository.db.entity.FavoriteEntity;
import com.overgara.test.xumak.screens.character.data.repository.service.dto.CharacterDTO;
import com.overgara.test.xumak.screens.character.domain.interactor.mapper.ObjectMapper;
import com.overgara.test.xumak.screens.character.presentation.model.Character;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CharacterInteractor implements ICharacterInteractor{

    private CharacterRepository dataSource;

    @Inject
    public CharacterInteractor(CharacterRepository dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<List<Character>> getCharacters(int limit, int offset) {
        return Observable.create(subscriber -> {
            List<FavoriteEntity> favoriteEntities = dataSource.getCharactersFromDB(limit,offset);
            if(favoriteEntities.size()>0) {
                subscriber.onNext(ObjectMapper.entityToCharacter(favoriteEntities));
                subscriber.onComplete();
            } else {
                responseFromApi(subscriber,limit,offset);
            }
        });
    }

    private void responseFromApi(ObservableEmitter<List<Character>> subscriber, int limit, int offset) {
        dataSource.getCharactersFromApi(limit, offset).subscribe(new Observer<List<CharacterDTO>>() {
            @Override
            public void onNext(List<CharacterDTO> list) {
                subscriber.onNext(ObjectMapper.dtoToCharacter(list));
            }

            @Override
            public void onError(Throwable e) {
                subscriber.onError(e);
            }
            @Override
            public void onSubscribe(Disposable d) {}
            @Override
            public void onComplete() {}
        });
    }

    @Override
    public Observable<Boolean> setFavorite(Character character) {
        return Observable.create(subscriber -> {
            int id;
            if(character.isFavorite()){
                id = dataSource.insert(ObjectMapper.characterToEntity(character));
            } else {
                id = dataSource.delete(character.getCharId());
            }
            subscriber.onNext(id>0);
            subscriber.onComplete();
        });
    }
}
