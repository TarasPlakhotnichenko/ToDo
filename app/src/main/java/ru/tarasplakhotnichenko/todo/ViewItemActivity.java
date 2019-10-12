package ru.tarasplakhotnichenko.todo;

import androidx.fragment.app.Fragment;

public class ViewItemActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return new ViewItemFrg();
    }
}