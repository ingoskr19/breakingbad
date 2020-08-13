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

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
public abstract class CharacterActivityModule {

    @Binds
    abstract CharacterActivity activity(CharacterActivity activity);


    @Provides
    static ICharacterInteractor interactor(CharacterRepository repository){
        return new CharacterInteractor(repository);
    }

    @Provides
    public static CharacterRepository repository(BreakingBadDataBase dataBase){
        return new CharacterDataSource(api(),dao(dataBase));
    }

    @Provides
    static CharacterApi api(){
        return new CharacterApi();
    }

    @Provides
    static CharacterDao dao(BreakingBadDataBase dataBase){
        return dataBase.characterDao();
    }
}
