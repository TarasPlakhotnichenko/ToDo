package ru.tarasplakhotnichenko.todo;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewItemFrg extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item, container, false);
        int index = getActivity().getIntent().getIntExtra("index", 0);
        Item item = Store.getStore().get(index);
        TextView name = view.findViewById(R.id.name);
        name.setText(item.getName());
        TextView desc = view.findViewById(R.id.desc);
        desc.setText(item.getDesc());
        return view;
    }
}
