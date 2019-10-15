package ru.tarasplakhotnichenko.todo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//
public class ViewFragmentActivity0 extends BaseActivity {
    @Override
    public Fragment loadFragment() {
        int index = getIntent().getIntExtra("index", 0);

        return ViewFragment0.instOf(index);
        //return new ViewFragment0();
    }
}
