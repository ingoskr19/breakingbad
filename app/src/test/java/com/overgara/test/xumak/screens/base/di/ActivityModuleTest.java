package com.overgara.test.xumak.screens.base.di;

import com.overgara.test.xumak.di.scopes.PerActivity;
import com.overgara.test.xumak.screens.character.module.CharacterActivityModuleTest;
import com.overgara.test.xumak.screens.character.presentation.view.CharacterActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Created By oscar.vergara on 16/08/2020
 */
@Module(includes = AndroidInjectionModule.class)
public abstract class ActivityModuleTest {

    @PerActivity
    @ContributesAndroidInjector(modules = {CharacterActivityModuleTest.class})
    abstract CharacterActivity characterActivity();
}
