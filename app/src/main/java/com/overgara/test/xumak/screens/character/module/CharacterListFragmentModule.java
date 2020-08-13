package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.adapter.CharacterAdapter;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterListFragment;
import com.overgara.test.xumak.screens.character.presentation.view.listener.CharacterClickListener;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created By oscar.vergara on 14/08/2020
 */
@Module(includes = CharacterActivityModule.class)
public abstract class CharacterListFragmentModule {

    @Binds
    public abstract CharacterListFragment view(CharacterListFragment fragment);

    @Binds
    public abstract CharacterClickListener listener(CharacterListFragment fragment);

    @Provides
    static CharacterAdapter adapter(CharacterClickListener listener) {
        return new CharacterAdapter(listener);
    }

}
