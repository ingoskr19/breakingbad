package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterDetailFragment;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
@InstallIn(FragmentComponent.class)
public abstract class CharacterDetailModule {

    @Binds
    @FragmentScoped
    abstract CharacterDetailFragment detailFragment(CharacterDetailFragment fragment);
}
