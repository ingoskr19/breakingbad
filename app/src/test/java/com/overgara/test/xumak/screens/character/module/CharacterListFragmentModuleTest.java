package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.adapter.CharacterAdapter;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterListFragment;
import com.overgara.test.xumak.screens.character.presentation.view.listener.CharacterClickListener;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

/**
 * Created By oscar.vergara on 14/08/2020
 */
@Module
@InstallIn(ApplicationComponent.class)
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

}
