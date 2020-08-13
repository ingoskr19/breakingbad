package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterDetailFragment;

import org.mockito.Mockito;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
public abstract class CharacterDetailModuleTest {

    @Provides
    static CharacterDetailFragment detailFragment(){
        return Mockito.mock(CharacterDetailFragment.class);
    }
}
