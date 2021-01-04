package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object secondObj) {
        if (this == secondObj) {
            return true;
        }
        if (secondObj == null || getClass() != secondObj.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) secondObj;
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
