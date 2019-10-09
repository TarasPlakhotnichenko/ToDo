package ru.tarasplakhotnichenko.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
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
            Item item = this.items.get(index);
            name.setText(String.format("%s. %s", index, item.getName()));
            created.setText(format(item.getCreated()));

            CheckBox done = holder.itemView.findViewById(R.id.done);
            done.setOnCheckedChangeListener((view, checked) item.setDone(checked));

            private String format(Calendar cal) {
                return String.format(
                        Locale.getDefault(), "%02d.%02d.%d",
                        cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH),cal.get(Calendar.YEAR)
                );
            }

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

        @Override
        public int getItemCount() {
            return this.items.size();
        }

        public  void delete(int i) {
            this.items.remove(this.items.get(i));
            notifyItemRemoved(i);
            notifyItemRangeChanged(i, items.size());
        }
    }
}