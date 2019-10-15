package ru.tarasplakhotnichenko.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//

public class ViewFragment1 extends Fragment {

    public static ViewFragment1 instOf(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        ViewFragment1 frg = new ViewFragment1();
        frg.setArguments(args);
        return frg;
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //parsing xml file
        View view = inflater.inflate(R.layout.fragment1, container, false);


        //
        int index = getArguments().getInt("index", 1);

        //we are going to attach a listener  to the button to move to screen0
        Button button1 = view.findViewById(R.id.buttonSreen1);
        button1.setOnClickListener(this::toScreen0);

        //to find element within xml file
        TextView name =  view.findViewById(R.id.myTextView1);
        name.setText("This is the fragment1 placed on the host layer (host_fragment)\nThis is index: " + index);

        return view;

    }


    public void toScreen0(View view) {
        Intent intent = new Intent(this.getActivity(), ViewFragmentActivity0.class );
        startActivity(intent);
    }


}