package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterDetailFragment;

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
public abstract class CharacterDetailModuleTest {

    @Provides
    static CharacterDetailFragment detailFragment(){
        return Mockito.mock(CharacterDetailFragment.class);
    }
}
