package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.data.repository.CharacterDataSource;
import com.overgara.test.xumak.screens.character.data.repository.CharacterRepository;
import com.overgara.test.xumak.screens.character.data.repository.db.CharacterDao;
import com.overgara.test.xumak.screens.character.data.repository.service.CharacterApi;
import com.overgara.test.xumak.screens.character.domain.interactor.CharacterInteractor;
import com.overgara.test.xumak.screens.character.domain.interactor.ICharacterInteractor;
import com.overgara.test.xumak.screens.character.presentation.view.adapter.CharacterAdapter;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterListFragment;
import com.overgara.test.xumak.screens.character.presentation.view.listener.CharacterClickListener;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

/**
 * Created By oscar.vergara on 14/08/2020
 */
@Module
public abstract class CharacterListFragmentModuleTest {

    @Provides
    static CharacterListFragment view(){
        return Mockito.mock(CharacterListFragment.class);
    }

    @Provides
    static CharacterClickListener listener(){
        return Mockito.mock(CharacterListFragment.class);
    }

    @Provides
    static CharacterAdapter adapter() {
        return Mockito.mock(CharacterAdapter.class);
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
