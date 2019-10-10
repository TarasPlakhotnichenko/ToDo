package ru.tarasplakhotnichenko.todo;

import java.util.Calendar;
import java.util.Objects;

public class Item {
    private String name;
    private Calendar created;
    private boolean done;

    public Item(String name,  Calendar created) {
        this.name = name;
        this.created = created;
    }

    //item name
    public String getName() {  return name;   }
    public void setName(String name) {  this.name = name;  }

    //item date
    public void  setCreated(Calendar created) {this.created = created;}
    public Calendar  getCreated() {return created;}

    //Item achievement
    public void setDone(boolean done) {this.done = done;}
    public boolean  isDone() { return done; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


