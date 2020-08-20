package com.overgara.test.xumak.base;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created By oscar.vergara on 12/08/2020
 */
public class BaseActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private TextView title;
    private ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
