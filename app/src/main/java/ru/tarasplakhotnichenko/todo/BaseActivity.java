package ru.tarasplakhotnichenko.todo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle saved){
        super.onCreate(saved);
        setContentView(R.layout.host_fragment);
        FragmentManager  fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.host_layer) == null) {
            fm.beginTransaction().add(R.id.host_layer, loadFragment()).commit();
        }
    }

    public abstract Fragment loadFragment();

}