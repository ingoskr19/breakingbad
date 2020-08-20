package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.data.repository.CharacterDataSource;
import com.overgara.test.xumak.screens.character.data.repository.CharacterRepository;
import com.overgara.test.xumak.screens.character.data.repository.db.CharacterDao;
import com.overgara.test.xumak.screens.character.data.repository.service.CharacterApi;
import com.overgara.test.xumak.screens.character.domain.interactor.CharacterInteractor;
import com.overgara.test.xumak.screens.character.domain.interactor.ICharacterInteractor;
import com.overgara.test.xumak.screens.character.presentation.view.CharacterActivity;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
@InstallIn(ApplicationComponent.class)
public abstract class CharacterActivityModuleTest {

    @Provides
    static CharacterActivity activity(){
        return Mockito.mock(CharacterActivity.class);
    }

    @Provides
    static ICharacterInteractor interactor(){
        return Mockito.mock(CharacterInteractor.class);
    }

    @Provides
    static CharacterRepository repository(){
        return Mockito.mock(CharacterDataSource.class);
    }

    @Provides
    static CharacterApi api(){
        return Mockito.mock(CharacterApi.class);
    }

    @Provides
    static CharacterDao dao(){
        return Mockito.mock(CharacterDao.class);
    }
}
