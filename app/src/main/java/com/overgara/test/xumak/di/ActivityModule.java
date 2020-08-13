package com.overgara.test.xumak.di;

import com.overgara.test.xumak.di.scopes.PerActivity;
import com.overgara.test.xumak.screens.character.module.CharacterActivityModule;
import com.overgara.test.xumak.screens.character.presentation.view.CharacterActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module(includes = AndroidInjectionModule.class)
public interface ActivityModule {

    //provide instances of activity's modules

    @PerActivity
    @ContributesAndroidInjector(modules = {CharacterActivityModule.class})
    CharacterActivity characterActivity();


}
