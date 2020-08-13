package com.overgara.test.xumak.screens.base.di;

import com.overgara.test.xumak.di.scopes.PerFragment;
import com.overgara.test.xumak.screens.character.module.CharacterDetailModuleTest;
import com.overgara.test.xumak.screens.character.module.CharacterListFragmentModuleTest;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterDetailFragment;
import com.overgara.test.xumak.screens.character.presentation.view.fragment.CharacterListFragment;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created By oscar.vergara on 16/08/2020
 */
@Module(includes = AndroidInjectionModule.class)
public interface FragmentModuleTest {

    @PerFragment
    @ContributesAndroidInjector(modules = {CharacterListFragmentModuleTest.class})
    CharacterListFragment characterListFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = {CharacterDetailModuleTest.class})
    CharacterDetailFragment characterDetailFragment();

}
