package ru.tarasplakhotnichenko.todo;

import androidx.fragment.app.Fragment;

public class ViewItemActivity extends BaseActivity {
    @Override
    public Fragment loadFrg() {
        int index = getIntent().getIntExtra("index", 0);
        return ViewItemFrg.instOf(index);
        //return new ViewItemFrg();
    }
}