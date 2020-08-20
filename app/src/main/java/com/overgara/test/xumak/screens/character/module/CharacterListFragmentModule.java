package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.adapter.CharacterAdapter;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterListFragment;
import com.overgara.test.xumak.screens.character.presentation.view.listener.CharacterClickListener;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.scopes.FragmentScoped;

/**
 * Created By oscar.vergara on 14/08/2020
 */
@Module
@InstallIn(FragmentComponent.class)
public abstract class CharacterListFragmentModule {

    @Binds
    @FragmentScoped
    public abstract CharacterListFragment view(CharacterListFragment fragment);

    @Binds
    @FragmentScoped
    public abstract CharacterClickListener listener(CharacterListFragment fragment);

    @Provides
    @FragmentScoped
    static CharacterAdapter adapter(CharacterClickListener listener) {
        return new CharacterAdapter(listener);
    }

}
