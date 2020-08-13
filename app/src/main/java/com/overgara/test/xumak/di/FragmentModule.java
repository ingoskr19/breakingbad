package com.overgara.test.xumak.di;

import com.overgara.test.xumak.di.scopes.PerFragment;
import com.overgara.test.xumak.screens.character.module.CharacterDetailModule;
import com.overgara.test.xumak.screens.character.module.CharacterListFragmentModule;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterDetailFragment;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterListFragment;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module(includes = AndroidInjectionModule.class)
public interface FragmentModule {

    //provide fragment's modules instances
    @PerFragment
    @ContributesAndroidInjector(modules = {CharacterListFragmentModule.class})
    CharacterListFragment characterListFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {CharacterDetailModule.class})
    CharacterDetailFragment characterDetailFragment();

}
