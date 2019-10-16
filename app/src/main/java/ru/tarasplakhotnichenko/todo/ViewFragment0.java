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

public class ViewFragment0 extends Fragment {

    public static ViewFragment0 instOf() {
        Bundle args = new Bundle();
        args.putInt("index", 0);
        ViewFragment0 frg = new ViewFragment0();
        frg.setArguments(args);
        return frg;
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //----------JUST FOR FUN-------------------------vvv
        String[]  wordList1 = {"круглосуточный", "трех-звенный", "взаимный", "на основе веб-технологий", "проникающий", "умный", "динамичный", "шесть сигм", "метод критического пути", "как всегда"};
        String[]  wordList2 = {"чистый продукт", "трудный", "уполномоченный","нестандартный ум","общий","совместный","сетевой","фирменный","ориентированный","нацеленный на","крутой", "получилось"};
        String[]  wordList3 = {"процесс","образец", "выход из положения", "талант","структура","обзор","пункт разгрузки","пятилетка"};
        int lenthW1 = wordList1.length;
        int lenthW2 = wordList2.length;
        int lenthW3 = wordList3.length;
        int rnd1 = (int) (Math.random() * lenthW1);
        int rnd2 = (int) (Math.random() * lenthW2);
        int rnd3 = (int) (Math.random() * lenthW3);
        String phrase = wordList1[rnd1] + " " + wordList2[rnd2] + " " + wordList3[rnd3];

        //----------JUST FOR FUN-------------------------^^^



        //parsing xml file
        View view = inflater.inflate(R.layout.fragment0, container, false);


        //we get a value passed from other screen that is the screen #1
        int index = getArguments().getInt("index", 0);

        //we are going to attach a listener  to the button to move to screen1
        Button button0 = view.findViewById(R.id.buttonSreen0);
        button0.setOnClickListener(this::toScreen1);

        //to find element within xml file
        TextView name =  view.findViewById(R.id.myTextView0);

        //name.setText("This is the fragment0 placed on the host layer (host_fragment)\nThis is index: " + index);
        name.setText("Все, что нам нужно, - это: "  + phrase);

        return view;

    }

    public void toScreen1(View view) {
        Intent intent = new Intent(this.getActivity(), ViewFragmentActivity1.class );
        startActivity(intent);
    }

}
