package ru.tarasplakhotnichenko.todo;

import androidx.fragment.app.Fragment;

public class AddItemActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return new AddItemFrg();
    }
}
