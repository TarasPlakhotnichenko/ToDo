package ru.tarasplakhotnichenko.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//

public class ViewFragment0 extends Fragment {

    public static ViewFragment0 instOf(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        ViewFragment0 frg = new ViewFragment0();
        frg.setArguments(args);
        return frg;
    }



    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //parsing xml file

        View view = inflater.inflate(R.layout.fragment0, container, false);

        //to find element within xml file
        TextView name =  view.findViewById(R.id.myTextView0);

        name.setText("This is a fragment placed on the host layer (host_fragment)");

        return view;

    }

}
