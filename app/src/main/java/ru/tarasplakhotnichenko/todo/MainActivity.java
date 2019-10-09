package ru.tarasplakhotnichenko.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final List<Item> items = new ArrayList<>();
    private final RecyclerView.Adapter adapter = new ItemAdapter(this.items);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

    public void add(View view) {
        EditText edit = this.findViewById(R.id.editText);
        this.items.add(new Item(edit.getText().toString(), Calendar.getInstance()));
        edit.setText("");
        adapter.notifyItemInserted(this.items.size() - 1);
    }

    public void updateItem(List<Item> items, int i) {
        //int index = i;
        //this.items.index();
    }

    private static final class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<Item> items;

        public ItemAdapter(List<Item> items)  {
            this.items = items;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int index) {
            return new RecyclerView.ViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.items, parent, false)
            ) {};
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int index) {
            TextView name = holder.itemView.findViewById(R.id.name);
            TextView created = holder.itemView.findViewById(R.id.created);

            //Item index and name
            Item item = this.items.get(index);
            name.setText(String.format("%s. %s", index, item.getName()));

            //Item date
            created.setText(format(item.getCreated()));

            //Item completion progress
            CheckBox done = holder.itemView.findViewById(R.id.done);
            done.setOnCheckedChangeListener((view, checked) -> {
                item.setDone(checked);
                TextView achieved  = holder.itemView.findViewById(R.id.completion);
                item.setCreated(Calendar.getInstance());
                achieved.setText(" -  completed" + " " + format(item.getCreated()));

            } );

            //---------------------------------------------------------------------
            /*
            Button deleteButton = holder.itemView.findViewById(R.id.delete);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delete(index);
                }
            });
            name.setText(String.format("%s. %s", index, this.items.get(index).getName()));
             */
            //---------------------------------------------------------------------
        }

        private String format(Calendar cal) {
            return String.format(

                    Locale.getDefault(), "%02d.%02d.%d",
                    //Locale.getDefault(), "%td.%td.%Y",
                    cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH),cal.get(Calendar.YEAR)
            );
        }



        @Override
        public int getItemCount() {
            return this.items.size();
        }

        /*
        public  void delete(int i) {
            this.items.remove(this.items.get(i));
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, items.size());
        }

        */
    }
}