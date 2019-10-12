package ru.tarasplakhotnichenko.todo;

import androidx.fragment.app.Fragment;

public class ItemsActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        return new ItemsFrg();
    }
}