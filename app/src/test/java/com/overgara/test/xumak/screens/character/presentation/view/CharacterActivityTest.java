package com.overgara.test.xumak.screens.character.presentation.view;

import com.overgara.test.xumak.screens.base.BaseApplicationTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;

/**
 * Created By oscar.vergara on 16/08/2020
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = BaseApplicationTest.class)
public class CharacterActivityTest {

    CharacterActivity mActivity;

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
