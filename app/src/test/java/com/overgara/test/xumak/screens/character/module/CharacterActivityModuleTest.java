package com.overgara.test.xumak.screens.character.module;

import com.overgara.test.xumak.screens.character.presentation.view.CharacterActivity;

import org.mockito.Mockito;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created By oscar.vergara on 12/08/2020
 */
@Module
public abstract class CharacterActivityModuleTest {

    @Provides
    static CharacterActivity activity(){
        return Mockito.mock(CharacterActivity.class);
    }
}
