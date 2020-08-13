package com.overgara.test.xumak.screens.character.presentation.view;

import android.os.Bundle;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;

import com.overgara.test.xumak.R;
import com.overgara.test.xumak.base.BaseActivity;

public class CharacterActivity extends BaseActivity implements HasDefaultViewModelProviderFactory {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }
}
