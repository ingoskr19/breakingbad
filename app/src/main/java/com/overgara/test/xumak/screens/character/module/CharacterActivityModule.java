package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.database.BreakingBadDataBase;
import com.overgara.test.xumak.screens.character.data.repository.CharacterDataSource;
import com.overgara.test.xumak.screens.character.data.repository.CharacterRepository;
import com.overgara.test.xumak.screens.character.data.repository.db.CharacterDao;
import com.overgara.test.xumak.screens.character.data.repository.service.CharacterApi;
import com.overgara.test.xumak.screens.character.domain.interactor.CharacterInteractor;
import com.overgara.test.xumak.screens.character.domain.interactor.ICharacterInteractor;
import com.overgara.test.xumak.screens.character.presentation.view.CharacterActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.scopes.ActivityRetainedScoped;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@InstallIn(ActivityRetainedComponent.class)
@Module
public abstract class CharacterActivityModule {

    @Binds
    @ActivityRetainedScoped
    abstract CharacterActivity activity(CharacterActivity activity);

    @Provides
    @ActivityRetainedScoped
    static ICharacterInteractor interactor(CharacterRepository repository){
        return new CharacterInteractor(repository);
    }

    @Provides
    @ActivityRetainedScoped
    public static CharacterRepository repository(CharacterApi api, CharacterDao dao){
        return new CharacterDataSource(api,dao);
    }

    @Provides
    @ActivityRetainedScoped
    public static CharacterApi api(){
        return new CharacterApi();
    }

    @Provides
    @ActivityRetainedScoped
    static CharacterDao dao(BreakingBadDataBase dataBase){
        return dataBase.characterDao();
    }
}
