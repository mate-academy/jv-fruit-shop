package model;

import java.util.Objects;

public class Fruit implements Cloneable {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public Fruit clone() {
        try {
            return (Fruit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone", e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
