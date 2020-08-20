package com.overgara.test.xumak.screens.character.presentation.view;

import com.overgara.test.xumak.screens.character.module.CharacterActivityModule;
import com.overgara.test.xumak.screens.character.module.CharacterDetailModule;
import com.overgara.test.xumak.screens.character.module.CharacterListFragmentModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import dagger.hilt.android.testing.HiltAndroidTest;
import dagger.hilt.android.testing.HiltTestApplication;
import dagger.hilt.android.testing.UninstallModules;

import static org.junit.Assert.assertFalse;

/**
 * Created By oscar.vergara on 16/08/2020
 */
@HiltAndroidTest
@RunWith(RobolectricTestRunner.class)
@Config(application = HiltTestApplication.class)
@UninstallModules({CharacterActivityModule.class, CharacterListFragmentModule.class, CharacterDetailModule.class})
public class CharacterActivityTest {

    private CharacterActivity mActivity;

    @Before
    public void setUp(){
        mActivity = Robolectric.buildActivity(CharacterActivity.class)
                .create()//.resume()
                .get();
    }

    @Test
    public void methodValidateThatOpenFragmentWhenActivityStarts() {
        assertFalse("The activity should active",mActivity.isFinishing());
    }

}
