package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterDetailFragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
public abstract class CharacterDetailModule {

    @Binds
    abstract CharacterDetailFragment detailFragment(CharacterDetailFragment fragment);
}
