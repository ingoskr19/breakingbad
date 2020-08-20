package com.overgara.test.xumak.screens.character.presentation.view;

import android.os.Bundle;

import com.overgara.test.xumak.R;
import com.overgara.test.xumak.base.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CharacterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }
}
