package ru.tarasplakhotnichenko.todo;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.add);


        //Mine------------

        int indexEdit = getIntent().getIntExtra("indexEdit", 0);
        boolean intentEditYes = getIntent().getBooleanExtra("indexEditYes", false);
        if (intentEditYes) {
            Item item = Store.getStore().get(indexEdit);

            TextView name = findViewById(R.id.name);
            name.setText(item.getName());

            TextView desc = this.findViewById(R.id.desc);
            desc.setText(item.getDesc());
        }


    }

    public void save(View view) {
        EditText edit = this.findViewById(R.id.name);
        EditText desc = this.findViewById(R.id.desc);
        Store.getStore().add(new Item(edit.getText().toString(), desc.getText().toString(), Calendar.getInstance()));

        Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}