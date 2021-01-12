package model;

import java.util.Objects;

public class Fruit {
    public String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Fruit current = (Fruit) obj;
            return name.equals(current.name);
        }
        return false;
    }
}
