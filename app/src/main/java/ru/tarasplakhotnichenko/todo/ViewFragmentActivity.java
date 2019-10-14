package ru.tarasplakhotnichenko.todo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewFragmentActivity extends BaseActivity {
    @Override
    public Fragment loadFragment() {
        return new ViewFragment();
    }
}
